package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class FileConfigTest {

    @Test
    public void hasUnexpected() {
        MatcherAssert.assertThat(
                "Unexpected attribute was loaded",
                !new FileConfig(new ByteArrayInputStream("a =b".getBytes())).has("d")
        );
    }

    @Test
    public void hasExpected() {
        MatcherAssert.assertThat(
                "Unexpected attribute was loaded",
                new FileConfig(new ByteArrayInputStream("a =b".getBytes())).has("a")
        );
    }

    @Test
    public void property() {
        MatcherAssert.assertThat(
                new FileConfig(new ByteArrayInputStream("a = b".getBytes())).attribute("a"),
                Matchers.equalTo("b")
        );
    }
}