package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class ClasspathConfigTest {

    @Test
    public void propertyReturnNotDefinedForUnknownKey() {
        MatcherAssert.assertThat(
                new ClasspathConfig("test.properties").property("a"),
                Matchers.equalTo("a")
        );
    }
}