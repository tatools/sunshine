package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class TestFromFileTest {

    @Test
    public void object() throws TestException {
        MatcherAssert.assertThat(
                new TestFromFile("org/tatools/sunshine/core/TestFromFile.class").object(),
                Matchers.equalTo(TestFromFile.class)
        );
    }

    @Test
    public void testToStringWithClassExtension() {
        MatcherAssert.assertThat(
                new TestFromFile("org/tatools/sunshine/core/TestFromFile.class").toString(),
                Matchers.equalTo("org.tatools.sunshine.core.TestFromFile")
        );
    }

    @Test
    public void testToStringWithoutClassExtension() {
        MatcherAssert.assertThat(
                new TestFromFile("org/tatools/sunshine/core/TestFromFile").toString(),
                Matchers.equalTo("org.tatools.sunshine.core.TestFromFile")
        );
    }


    @Test
    public void testFilter() {
        MatcherAssert.assertThat(
                new TestFromFile("org/tatools/sunshine/core/TestFromFile")
                        .match("org.tatools.sunshine.core.TestFromFile"::equals),
                Matchers.is(true)
        );
    }
}