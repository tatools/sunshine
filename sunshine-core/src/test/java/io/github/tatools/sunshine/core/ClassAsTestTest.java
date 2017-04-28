package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
public class ClassAsTestTest {

    @Test
    public void object() {
        MatcherAssert.assertThat(
                new ClassAsTest("io/github/tatools/sunshine/core/ClassAsTest.class").object(),
                Matchers.equalTo(ClassAsTest.class)
        );
    }

    @Test
    public void toStringImpl() {
        MatcherAssert.assertThat(
                new ClassAsTest("io/github/tatools/sunshine/core/ClassAsTest.class").toString(),
                Matchers.equalTo("io.github.tatools.sunshine.core.ClassAsTest")
        );
    }
}