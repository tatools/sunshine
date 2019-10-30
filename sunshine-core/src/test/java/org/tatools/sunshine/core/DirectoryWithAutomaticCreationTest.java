package org.tatools.sunshine.core;

import java.io.IOException;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DirectoryWithAutomaticCreationTest {
    @Rule public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void create() throws IOException {
        final FileSystemPathBase path =
                new FileSystemPathBase(testFolder.newFolder().toString(), "a");
        new DirectoryWithAutomaticCreation(new DirectoryBase(path)).create();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }

    @Test
    public void remove() throws IOException {
        final FileSystemPathBase path = new FileSystemPathBase(testFolder.newFolder().toString());
        new DirectoryWithAutomaticCreation(new DirectoryBase(path)).remove();
        MatcherAssert.assertThat("The directory wasn't removed", !path.exist());
    }

    @Test
    public void exist() throws IOException {
        final FileSystemPathBase path =
                new FileSystemPathBase(testFolder.newFolder().toString(), "a");
        new DirectoryWithAutomaticCreation(new DirectoryBase(path)).exist();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }

    @Test
    public void path() throws IOException {
        final FileSystemPathBase path =
                new FileSystemPathBase(testFolder.newFolder().toString(), "a");
        new DirectoryWithAutomaticCreation(new DirectoryBase(path)).path();
        MatcherAssert.assertThat("The directory wasn't created", path.exist());
    }
}
