package org.tatools.sunshine.core;

import java.io.IOException;
import java.nio.file.Files;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileBaseTest {
    @Rule public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void write() throws IOException {
        final FileBase file = new FileBase(testFolder.getRoot().getAbsolutePath(), "ccc");
        file.write("dasd");
        MatcherAssert.assertThat(Files.exists(file.path()), Matchers.is(true));
    }
}
