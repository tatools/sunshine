package io.github.tatools.sunshine;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
public class SystemTestsPatternTest {
    @Test
    public void value() {
        System.setProperty("tests", "a");
        MatcherAssert.assertThat(
                new SystemTestsPattern().value(),
                Matchers.equalTo("a")
        );
    }

    @Test
    public void present() {
        MatcherAssert.assertThat(
                "Property is set",
                !new SystemTestsPattern().present()
        );
    }

}