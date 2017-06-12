package io.github.tatools.sunshine.core;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 10.06.2017
 */
public class PrintableSuiteTest {

    @Test
    public void tests() throws IOException {
        final SunshineTest.Fake test = new SunshineTest.Fake();
        MatcherAssert.assertThat(
                new PrintableSuite(new SunshineSuite.Fake(test)).tests(),
                Matchers.contains(test)
        );
    }
}
