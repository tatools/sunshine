package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class JarFileTest {
    @Test
    public void files() throws IOException {
        MatcherAssert.assertThat(
                new JarFile("src/test/resources/sample-tests.jar").files(),
                Matchers.hasItem(new RegularPath("io/github/tatools/testng/Test1.class"))
        );
    }

    @Test(expected = IOException.class)
    public void incorrectPath() throws IOException {
        new JarFile("faffasfas").files();
    }
}