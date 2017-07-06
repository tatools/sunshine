package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConfigFromFileTest {

    @Test
    public void hasUnexpected() {
        MatcherAssert.assertThat(
                "Unexpected attribute was loaded",
                !new ConfigFromFile(new ByteArrayInputStream("a =b".getBytes())).has("d")
        );
    }

    @Test
    public void hasExpected() {
        MatcherAssert.assertThat(
                "Unexpected attribute was loaded",
                new ConfigFromFile(new ByteArrayInputStream("a =b".getBytes())).has("a")
        );
    }

    @Test
    public void property() {
        MatcherAssert.assertThat(
                new ConfigFromFile(new ByteArrayInputStream("a = b".getBytes())).attribute("a"),
                Matchers.equalTo("b")
        );
    }
}