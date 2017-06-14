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
public class CompositeFilesystemTest {
    @Test
    public void files() throws SuiteException {
        List<Filesystem> filesystems = Arrays.asList(
                new Filesystem.Fake(Collections.singletonList(new FsPath.Fake())),
                new Filesystem.Fake(Collections.singletonList(new FsPath.Fake()))
        );
        MatcherAssert.assertThat(
                new CompositeFilesystem(filesystems).files(),
                Matchers.hasSize(2)
        );
    }
}