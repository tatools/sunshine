package io.github.tatools.sunshine;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class ReportFolderTest {
    @org.junit.Test
    public void value() {
        MatcherAssert.assertThat(
                new ReportFolder(new ClasspathConfig("test.properties")).value(),
                Matchers.equalTo("aa")
        );
    }
}