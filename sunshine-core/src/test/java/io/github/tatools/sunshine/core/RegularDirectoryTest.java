package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 24.04.2017
 */
public class RegularDirectoryTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void create() {
        final RegularPath path = new RegularPath(testFolder.getRoot().getAbsolutePath(), "a");
        new RegularDirectory(path).create();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }

    @Test
    public void remove() throws IOException {
        java.io.File file = testFolder.newFolder();
        final RegularPath path = new RegularPath(file.toString());
        new RegularDirectory(path).remove();
        MatcherAssert.assertThat("The directory exists", !path.exist());
    }

    @Test
    public void exist() {
        MatcherAssert.assertThat(
                "The directory isn't present",
                new RegularDirectory(new RegularPath(testFolder.getRoot().getAbsolutePath())).exist()
        );
    }

    @Test
    public void path() {
        final String path = "a";
        MatcherAssert.assertThat(
                new RegularDirectory(path).path(),
                Matchers.equalTo(Paths.get(path))
        );
    }
}