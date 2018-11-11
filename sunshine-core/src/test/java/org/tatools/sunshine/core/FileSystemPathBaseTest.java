package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemPathBaseTest {

    @Test
    public void path() {
        final String path = "aa";
        MatcherAssert.assertThat(
                new FileSystemPathBase(path).path(),
                Matchers.equalTo(Paths.get(path))
        );
    }

    @Test
    public void pathWithFolder() {
        final String directory = "aa";
        final String file = "file";
        MatcherAssert.assertThat(
                new FileSystemPathBase(directory, file).path(),
                Matchers.equalTo(Paths.get(directory + "/" + file))
        );
    }

    @Test
    public void exist() {
        MatcherAssert.assertThat(
                "File is absent",
                new FileSystemPathBase("src/main/java/org/tatools/sunshine/core/FileSystemPathBase.java").exist()
        );
    }
}