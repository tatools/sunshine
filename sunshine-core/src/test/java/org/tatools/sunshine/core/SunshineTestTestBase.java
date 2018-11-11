package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SunshineTestTestBase {

    @Test
    public void object() throws TestException {
        MatcherAssert.assertThat(
                new SunshineTestBase("org/tatools/sunshine/core/SunshineTestBase.class").object(),
                Matchers.equalTo(SunshineTestBase.class)
        );
    }

    @Test
    public void toStringImpl() {
        MatcherAssert.assertThat(
                new SunshineTestBase("org/tatools/sunshine/core/SunshineTestBase.class").toString(),
                Matchers.equalTo("org.tatools.sunshine.core.SunshineTestBase")
        );
    }
}