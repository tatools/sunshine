package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class PatternRuleTest {

    @Test
    public void relevant() {
        MatcherAssert.assertThat(
                "Regex doesn't work",
                new PatternRule("(.+)([Tt]est)([\\w\\d]+)?").pass("io.github.my.FirstTest")
        );
    }
}