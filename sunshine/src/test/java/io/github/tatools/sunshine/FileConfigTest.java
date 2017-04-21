package io.github.tatools.sunshine;

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
    public void propertyReturnNotDefinedForUnknownKey() {
        MatcherAssert.assertThat(
                new FileConfig(new ByteArrayInputStream("a =b".getBytes())).property("da"),
                Matchers.equalTo("not defined")
        );
    }

    @Test
    public void property() {
        MatcherAssert.assertThat(
                new FileConfig(new ByteArrayInputStream("a = b".getBytes())).property("a"),
                Matchers.equalTo("b")
        );
    }
}