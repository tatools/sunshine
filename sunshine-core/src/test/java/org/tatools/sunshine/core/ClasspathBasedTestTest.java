package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ClasspathBasedTestTest {

    @Test
    public void object() throws TestException {
        MatcherAssert.assertThat(
                new ClasspathBasedTest("org/tatools/sunshine/core/ClasspathBasedTest.class").object(),
                Matchers.equalTo(ClasspathBasedTest.class)
        );
    }

    @Test
    public void testToStringWithClassExtension() {
        MatcherAssert.assertThat(
                new ClasspathBasedTest("org/tatools/sunshine/core/ClasspathBasedTest.class").toString(),
                Matchers.equalTo("org.tatools.sunshine.core.ClasspathBasedTest")
        );
    }

    @Test
    public void testToStringWithoutClassExtension() {
        MatcherAssert.assertThat(
                new ClasspathBasedTest("org/tatools/sunshine/core/ClasspathBasedTest").toString(),
                Matchers.equalTo("org.tatools.sunshine.core.ClasspathBasedTest")
        );
    }
}