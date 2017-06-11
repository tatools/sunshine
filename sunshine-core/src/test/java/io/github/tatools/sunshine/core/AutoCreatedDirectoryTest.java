package io.github.tatools.sunshine.core;


import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 11.06.2017
 */
public class AutoCreatedDirectoryTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void create() throws IOException {
        final RegularPath path = new RegularPath(testFolder.newFolder().toString(), "a");
        new AutoCreatedDirectory(new RegularDirectory(path)).create();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }

    @Test
    public void remove() throws IOException {
        final RegularPath path = new RegularPath(testFolder.newFolder().toString());
        new AutoCreatedDirectory(new RegularDirectory(path)).remove();
        MatcherAssert.assertThat("The directory wasn't removed", !path.exist());
    }

    @Test
    public void exist() throws IOException {
        final RegularPath path = new RegularPath(testFolder.newFolder().toString(), "a");
        new AutoCreatedDirectory(new RegularDirectory(path)).exist();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }

    @Test
    public void path() throws IOException {
        final RegularPath path = new RegularPath(testFolder.newFolder().toString(), "a");
        new AutoCreatedDirectory(new RegularDirectory(path)).path();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }
}