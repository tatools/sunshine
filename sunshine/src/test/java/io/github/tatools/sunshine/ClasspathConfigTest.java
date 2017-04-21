package io.github.tatools.sunshine;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class ClasspathConfigTest {

    @org.junit.Test
    public void propertyReturnNotDefinedForUnknownKey() {
        MatcherAssert.assertThat(
                new ClasspathConfig("test.properties").property("a"),
                Matchers.equalTo("a")
        );
    }
}