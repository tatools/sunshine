package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DirectoryBaseTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void create() throws IOException {
        final FileSystemPathBase path = new FileSystemPathBase(testFolder.getRoot().getAbsolutePath(), "a");
        new DirectoryBase(path).create();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }

    @Test
    public void remove() throws IOException {
        java.io.File file = testFolder.newFolder();
        final FileSystemPathBase path = new FileSystemPathBase(file.toString());
        new DirectoryBase(path).remove();
        MatcherAssert.assertThat("The directory exists", !path.exist());
    }

    @Test
    public void exist() {
        MatcherAssert.assertThat(
                "The directory isn't present",
                new DirectoryBase(new FileSystemPathBase(testFolder.getRoot().getAbsolutePath())).exist()
        );
    }

    @Test
    public void path() {
        final String path = "a";
        MatcherAssert.assertThat(
                new DirectoryBase(path).path(),
                Matchers.equalTo(Paths.get(path))
        );
    }
}