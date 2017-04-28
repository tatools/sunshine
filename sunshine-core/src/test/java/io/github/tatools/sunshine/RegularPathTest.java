package io.github.tatools.sunshine;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 24.04.2017
 */
public class RegularPathTest {

    @Test
    public void path() {
        final String path = "aa";
        MatcherAssert.assertThat(
                new RegularPath(path).path(),
                Matchers.equalTo(Paths.get(path))
        );
    }

    @Test
    public void pathWithFolder() {
        final String directory = "aa";
        final String file = "file";
        MatcherAssert.assertThat(
                new RegularPath(directory, file).path(),
                Matchers.equalTo(Paths.get(directory + "/" + file))
        );
    }

    @Test
    public void exist() {
        MatcherAssert.assertThat(
                "File is absent",
                new RegularPath("src/test/resources/test.properties").exist()
        );
    }
}