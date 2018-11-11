package org.tatools.sunshine.junit4;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.Result;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class JunitStatusTest {
    @Test
    public void codeIfPassed() {
        MatcherAssert.assertThat(
                new JunitStatus(new FakeResult(true, 0, 0, 0)).code(),
                Matchers.is((short) 0)
        );
    }

    @Test
    public void codeIfFailed() {
        MatcherAssert.assertThat(
                new JunitStatus(new FakeResult(false, 0, 0, 0)).code(),
                Matchers.is((short) 1)
        );
    }

    @Test
    public void runCount() {
        MatcherAssert.assertThat(
                new JunitStatus(new FakeResult(false, 3, 0, 0)).runCount(),
                Matchers.is(3)
        );
    }

    @Test
    public void failureCount() {
        MatcherAssert.assertThat(
                new JunitStatus(new FakeResult(false, 0, 2, 0)).failureCount(),
                Matchers.is(2)
        );
    }

    @Test
    public void ignoreCount() {
        MatcherAssert.assertThat(
                new JunitStatus(new FakeResult(false, 0, 0, 5)).ignoreCount(),
                Matchers.is(5)
        );
    }

    private final class FakeResult extends Result {
        private static final long serialVersionUID = -7061965103897931256L;
        private final boolean wasSuccessful;
        private final int runCount;
        private final int failureCount;
        private final int ignoreCount;

        FakeResult(boolean successful, int total, int failed, int ignored) {
            this.wasSuccessful = successful;
            this.runCount = total;
            this.failureCount = failed;
            this.ignoreCount = ignored;
        }

        @Override
        public int getRunCount() {
            return this.runCount;
        }

        @Override
        public int getFailureCount() {
            return this.failureCount;
        }

        @Override
        public int getIgnoreCount() {
            return this.ignoreCount;
        }

        @Override
        public boolean wasSuccessful() {
            return this.wasSuccessful;
        }
    }
}
