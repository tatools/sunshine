package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RunWith(Parameterized.class)
public class RegexConditionTest {

    private final String className;

    public RegexConditionTest(String className) {
        this.className = className;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"io.github.my.FirstTest"},
                {"io.github.my.FirstTest1"},
                {"io.github.my.Test"},
                {"io.github.my.1Test"},
                {"io.github.my.FirstTestDo"},
        });
    }

    @Test
    public void applicable() {
        MatcherAssert.assertThat(
                "Regex doesn't work for " + this.className,
                new RegexCondition().applicable(this.className)
        );
    }
}