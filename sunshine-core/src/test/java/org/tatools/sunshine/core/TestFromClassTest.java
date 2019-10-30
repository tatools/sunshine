package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class TestFromClassTest {

    @Test
    public void testObject() throws TestException {
        MatcherAssert.assertThat(
                new TestFromClass(TestFromClass.class).object(),
                Matchers.equalTo(TestFromClass.class));
    }

    @Test
    public void testToString() {
        MatcherAssert.assertThat(
                new TestFromClass(TestFromClass.class).toString(),
                Matchers.equalTo("org.tatools.sunshine.core.TestFromClass"));
    }

    @Test
    public void testFilter() {
        MatcherAssert.assertThat(
                new TestFromClass(TestFromClass.class)
                        .match("org.tatools.sunshine.core.TestFromClass"::equals),
                Matchers.is(true));
    }
}
