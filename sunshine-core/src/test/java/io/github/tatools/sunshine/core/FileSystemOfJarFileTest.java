package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemOfJarFileTest {
    @Test
    public void files() throws FileSystemException {
        MatcherAssert.assertThat(
                new FileSystemOfJarFile("build/sample-tests.jar").files(),
                Matchers.hasItem(new FileSystemPathBase("io/github/tatools/testng/Test1.class"))
        );
    }

    @Test(expected = FileSystemException.class)
    public void incorrectPath() throws FileSystemException {
        new FileSystemOfJarFile("faffasfas").files();
    }
}