package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class JarFileTest {
    @Test
    public void files() throws SuiteException {
        MatcherAssert.assertThat(
                new JarFile("src/test/resources/sample-tests.jar").files(),
                Matchers.hasItem(new RegularPath("io/github/tatools/testng/Test1.class"))
        );
    }

    @Test(expected = SuiteException.class)
    public void incorrectPath() throws SuiteException {
        new JarFile("faffasfas").files();
    }
}