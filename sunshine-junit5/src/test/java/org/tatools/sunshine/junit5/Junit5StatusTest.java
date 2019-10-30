package org.tatools.sunshine.junit5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;
import java.util.List;

/**
 * @author Dmytro Serdiuk
 * @version $Id$
 */
class Junit5StatusTest {

    @Test
    void codePassed() {
        MatcherAssert.assertThat(
                new Junit5Status(new Summary(1, 0, 0, 0)).code(),
                Matchers.is((short)0)
        );
    }

    @Test
    void codeFailed() {
        MatcherAssert.assertThat(
                new Junit5Status(new Summary(1, 0, 0, 1)).code(),
                Matchers.is((short)1)
        );
    }

    @Test
    void runCount() {
        MatcherAssert.assertThat(
                new Junit5Status(new Summary(5, 4, 3, 1)).runCount(),
                Matchers.is(5)
        );
    }

    @Test
    void failureCount() {
        MatcherAssert.assertThat(
                new Junit5Status(new Summary(5, 4, 3, 1)).failureCount(),
                Matchers.is(4)
        );
    }

    @Test
    void ignoreCount() {
        MatcherAssert.assertThat(
                new Junit5Status(new Summary(5, 4, 3, 1)).ignoreCount(),
                Matchers.is(3)
        );
    }

    private final class Summary implements TestExecutionSummary {
        private final long totalTests;
        private final long failedCount;
        private final long skippedCount;
        private final long totalFailedCount;

        public Summary(long totalTests, long failedCount, long skippedCount, long totalFailedCount) {
            this.totalTests = totalTests;
            this.failedCount = failedCount;
            this.skippedCount = skippedCount;
            this.totalFailedCount = totalFailedCount;
        }

        @Override
        public long getTimeStarted() {
            return 0;
        }

        @Override
        public long getTimeFinished() {
            return 0;
        }

        @Override
        public long getTotalFailureCount() {
            return this.totalFailedCount;
        }

        @Override
        public long getContainersFoundCount() {
            return 0;
        }

        @Override
        public long getContainersStartedCount() {
            return 0;
        }

        @Override
        public long getContainersSkippedCount() {
            return 0;
        }

        @Override
        public long getContainersAbortedCount() {
            return 0;
        }

        @Override
        public long getContainersSucceededCount() {
            return 0;
        }

        @Override
        public long getContainersFailedCount() {
            return 0;
        }

        @Override
        public long getTestsFoundCount() {
            return this.totalTests;
        }

        @Override
        public long getTestsStartedCount() {
            return 0;
        }

        @Override
        public long getTestsSkippedCount() {
            return this.skippedCount;
        }

        @Override
        public long getTestsAbortedCount() {
            return 0;
        }

        @Override
        public long getTestsSucceededCount() {
            return 0;
        }

        @Override
        public long getTestsFailedCount() {
            return this.failedCount;
        }

        @Override
        public void printTo(PrintWriter writer) {

        }

        @Override
        public void printFailuresTo(PrintWriter writer) {

        }

        @Override
        public List<Failure> getFailures() {
            return null;
        }
    }
}
