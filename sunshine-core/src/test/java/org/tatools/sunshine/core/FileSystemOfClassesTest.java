package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemOfClassesTest {
    @Test
    public void onlyFilesInFileSystem() throws FileSystemException {
        MatcherAssert.assertThat(
                new FileSystemOfClasses(new FileSystem.Fake(
                        Arrays.asList(
                                new FileSystemPath.Fake("SomeTest.class"),
                                new FileSystemPath.Fake("some-file.txt")
                        )
                )).files(),
                Matchers.hasSize(1)
        );
    }

    @Test
    public void filesAndJarsInFileSystem() throws FileSystemException {
        MatcherAssert.assertThat(
                new FileSystemOfClasses(
                        new FileSystemOfJarFile("build/sample-tests.jar")
                ).files(),
                Matchers.hasSize(5)
        );
    }
}