package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SunshineSuitePrintableTest {

    @Test
    public void tests() throws SuiteException {
        final SunshineTest.Fake test = new SunshineTest.Fake();
        MatcherAssert.assertThat(
                new SunshineSuitePrintable(new SunshineSuite.Fake(test)).tests(),
                Matchers.contains(test));
    }
}
