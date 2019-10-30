package org.tatools.sunshine.core;

import java.util.Collections;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemFilteredTest {
    @Test
    public void files() throws FileSystemException {
        MatcherAssert.assertThat(
                new FileSystemFiltered(
                                new FileSystem.Fake(
                                        Collections.singletonList(new FileSystemPath.Fake())),
                                new Condition.Fake(false))
                        .files(),
                Matchers.hasSize(0));
    }
}
