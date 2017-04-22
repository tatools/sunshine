package io.github.tatools.sunshine;

import org.hamcrest.MatcherAssert;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class PatternRuleTest {
    @org.junit.Test
    public void relevant() {
        MatcherAssert.assertThat(
                "Regex doesn't work",
                new PatternRule("(.+)([Tt]est)([\\w\\d]+)?").pass("io.github.my.FirstTest")
        );
    }
}