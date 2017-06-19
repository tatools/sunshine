package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class FileSystemOfJarFilesTest {
    @Test
    public void files() throws FileSystemException {
        MatcherAssert.assertThat(
                new FileSystemOfJarFiles(
                        new FileSystem.Fake(
                                new FsPath.Fake("build/sample-tests.jar"),
                                new FsPath.Fake("build/sample-tests.jar")
                        )
                ).files(),
                Matchers.hasSize(22)
        );
    }

}