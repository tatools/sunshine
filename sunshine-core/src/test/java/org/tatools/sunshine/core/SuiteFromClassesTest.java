package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class SuiteFromClassesTest {

    @Test
    public void tests() throws SuiteException {
        MatcherAssert.assertThat(
                new SuiteFromClasses(SuiteFromClasses.class).tests(), Matchers.hasSize(1));
    }
}
