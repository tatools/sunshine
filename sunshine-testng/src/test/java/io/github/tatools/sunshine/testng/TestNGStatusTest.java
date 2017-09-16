package io.github.tatools.sunshine.testng;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.ISuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class TestNGStatusTest {
    @Test
    public void code() {
        MatcherAssert.assertThat(
                new TestNGStatus(4, Collections.emptyList()).code(),
                Matchers.equalTo((short) 4)
        );
    }

    @Test
    public void runCount() {
        MatcherAssert.assertThat(
                new TestNGStatus(0, this.suites()).runCount(),
                Matchers.equalTo(0)
        );
    }

    @Test
    public void failureCount() {
        MatcherAssert.assertThat(
                new TestNGStatus(0, this.suites()).failureCount(),
                Matchers.equalTo(0)
        );
    }

    @Test
    public void ignoreCount() {
        MatcherAssert.assertThat(
                new TestNGStatus(0, this.suites()).ignoreCount(),
                Matchers.equalTo(0)
        );
    }

    private List<ISuite> suites() {
        final ArrayList<ISuite> suitesHolder = new ArrayList<>();
        final SunshineTestNG sunshineTestNG = new SunshineTestNG(suitesHolder);
        sunshineTestNG.setTestSuites(Arrays.asList("src/test/resources/testng.xml"));
        sunshineTestNG.run();
        return suitesHolder;
    }

}
