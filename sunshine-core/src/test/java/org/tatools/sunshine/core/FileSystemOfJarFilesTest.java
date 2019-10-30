package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemOfJarFilesTest {
    @Test
    public void files() throws FileSystemException {
        MatcherAssert.assertThat(
                new FileSystemOfJarFiles(
                                new FileSystem.Fake(
                                        new FileSystemPath.Fake("build/sample-tests.jar"),
                                        new FileSystemPath.Fake("build/sample-tests.jar")))
                        .files(),
                Matchers.hasSize(20));
    }
}
