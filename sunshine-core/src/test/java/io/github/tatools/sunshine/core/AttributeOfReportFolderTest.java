package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class AttributeOfReportFolderTest {

    @Test
    public void value() {
        MatcherAssert.assertThat(
                new AttributeOfReportFolder(new ConfigFromClasspathFile("test.properties")).value(),
                Matchers.equalTo("aa")
        );
    }
}