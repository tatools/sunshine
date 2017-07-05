package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
public class AttributeOfTestPatternTestFromCli {
    @Test
    public void value() {
        System.setProperty("tests", "a");
        MatcherAssert.assertThat(
                new AttributeOfTestPatternFromCli().value(),
                Matchers.equalTo("a")
        );
    }

    @Test
    public void present() {
        MatcherAssert.assertThat(
                "Attribute is set",
                !new AttributeOfTestPatternFromCli().present()
        );
    }

}