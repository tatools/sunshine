package org.tatools.sunshine.testng;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.ISuite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class SunshineTestNGTest {
    @Test
    public void runSuites() {
        final ArrayList<ISuite> suitesHolder = new ArrayList<>();
        final SunshineTestNG sunshineTestNG = new SunshineTestNG(suitesHolder);
        sunshineTestNG.setTestSuites(Arrays.asList("src/test/resources/testng.xml"));
        sunshineTestNG.run();
        MatcherAssert.assertThat(suitesHolder, Matchers.hasSize(1));
    }
}
