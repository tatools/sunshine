package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class FileSystemOfClasspathClassesTest {

    @Test
    public void files() throws FileSystemException {
        MatcherAssert.assertThat(new FileSystemOfClasspathClasses().files(), Matchers.not(Matchers.empty()));
    }
}