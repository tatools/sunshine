package io.github.tatools.sunshine.core;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DirectoryWithAutomaticDeletionTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void create() throws IOException {
        final java.io.File file = testFolder.getRoot();
        new DirectoryWithAutomaticDeletion(new Directory.Fake(file.toPath())).create();
        MatcherAssert.assertThat("The directory wasn't created", file.exists());
    }

    @Test
    public void remove() throws IOException {
        final java.io.File file = testFolder.getRoot();
        new DirectoryWithAutomaticDeletion(new Directory.Fake(file.toPath())).remove();
        MatcherAssert.assertThat("The directory exists", file.exists());
    }

    @Test
    public void exist() {
        MatcherAssert.assertThat(
                "The directory isn't present",
                new DirectoryWithAutomaticDeletion(
                        new Directory.Fake(testFolder.getRoot().toPath(), true)
                ).exist()
        );
    }

    @Test
    public void path() {
        final Path file = testFolder.getRoot().toPath();
        MatcherAssert.assertThat(
                new DirectoryWithAutomaticDeletion(new Directory.Fake(file)).path(),
                Matchers.equalTo(file)
        );
    }
}