package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class FileSystemOfFileSystemsTest {
    @Test
    public void files() throws FileSystemException {
        List<FileSystem> fileSystems = Arrays.asList(
                new FileSystem.Fake(Collections.singletonList(new FileSystemPath.Fake())),
                new FileSystem.Fake(Collections.singletonList(new FileSystemPath.Fake()))
        );
        MatcherAssert.assertThat(
                new FileSystemOfFileSystems(fileSystems).files(),
                Matchers.hasSize(2)
        );
    }
}