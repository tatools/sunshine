package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConfigFromClasspathFileTest {

    @Test
    public void propertyReturnNotDefinedForUnknownKey() {
        MatcherAssert.assertThat(
                new ConfigFromClasspathFile("test.properties").attribute("a"),
                Matchers.equalTo("a")
        );
    }
}