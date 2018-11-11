package org.tatools.sunshine.core;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemOfPathTest {

    private static final String RESOURCES = "src/test/java";

    @Test
    public void files() throws FileSystemException {
        CustomTypeSafeMatcher<Integer> matcher = new CustomTypeSafeMatcher<Integer>("Has at least one item") {
            @Override
            protected boolean matchesSafely(Integer item) {
                return item > 0;
            }
        };
        MatcherAssert.assertThat(new FileSystemOfPath(RESOURCES).files(), Matchers.hasSize(matcher));
    }
}