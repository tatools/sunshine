package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class RegexConditionTest {

    @Test
    public void applicable() {
        MatcherAssert.assertThat(
                "Regex doesn't work",
                new RegexCondition("(.+)([Tt]est)([\\w\\d]+)?").applicable("io.github.my.FirstTest")
        );
    }
}