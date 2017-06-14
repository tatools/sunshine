package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
public class BaseTestTest {

    @Test
    public void object() throws TestException {
        MatcherAssert.assertThat(
                new BaseTest("io/github/tatools/sunshine/core/BaseTest.class").object(),
                Matchers.equalTo(BaseTest.class)
        );
    }

    @Test
    public void toStringImpl() {
        MatcherAssert.assertThat(
                new BaseTest("io/github/tatools/sunshine/core/BaseTest.class").toString(),
                Matchers.equalTo("io.github.tatools.sunshine.core.BaseTest")
        );
    }
}