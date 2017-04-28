package io.github.tatools.sunshine.core;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.nio.file.Files;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public class WritableFileTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void write() {
        final WritableFile file = new WritableFile(testFolder.getRoot().getAbsolutePath(), "ccc");
        file.write("dasd");
        MatcherAssert.assertThat(Files.exists(file.path()), Matchers.is(true));
    }
}