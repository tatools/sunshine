package org.tatools.sunshine.core;

import java.util.Arrays;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class CompositeStatusTest {

    @Test
    public void testZeroCode() {
        MatcherAssert.assertThat(
                new CompositeStatus(Arrays.asList(new Status.Fake(), new Status.Fake())).code(),
                Matchers.is((short) 0));
    }

    @Test
    public void testNonZeroPositiveCode() {
        MatcherAssert.assertThat(
                new CompositeStatus(
                                Arrays.asList(
                                        new Status.Fake((short) 3, 0, 1, 1),
                                        new Status.Fake((short) 2, 0, 1, 1)))
                        .code(),
                Matchers.is((short) 3));
    }

    @Test
    public void testNonZeroNegativeCode() {
        MatcherAssert.assertThat(
                new CompositeStatus(
                                Arrays.asList(
                                        new Status.Fake((short) -3, 0, 1, 1),
                                        new Status.Fake((short) 0, 0, 1, 1)))
                        .code(),
                Matchers.is((short) -3));
    }

    @Test
    public void testSumOfRunCount() {
        MatcherAssert.assertThat(
                new CompositeStatus(
                                Arrays.asList(
                                        new Status.Fake((short) 3, 1, 2, 3),
                                        new Status.Fake((short) 2, 4, 5, 6)))
                        .runCount(),
                Matchers.is(5));
    }

    @Test
    public void testSumOfFailureCount() {
        MatcherAssert.assertThat(
                new CompositeStatus(
                                Arrays.asList(
                                        new Status.Fake((short) 3, 1, 2, 3),
                                        new Status.Fake((short) 2, 4, 5, 6)))
                        .failureCount(),
                Matchers.is(7));
    }

    @Test
    public void testSumOfIgnoreCount() {
        MatcherAssert.assertThat(
                new CompositeStatus(
                                Arrays.asList(
                                        new Status.Fake((short) 3, 1, 2, 3),
                                        new Status.Fake((short) 2, 4, 5, 6)))
                        .ignoreCount(),
                Matchers.is(9));
    }
}
