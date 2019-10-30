package org.tatools.sunshine.junit5;

import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.tatools.sunshine.core.Status;

/**
 * The class provides an implementation of the {@link Status} for JUnit 5 execution.
 *
 * @author Dmytro Serdiuk
 * @version $Id$
 */
public class Junit5Status implements Status {
    private final TestExecutionSummary summary;
    private final short passed = 0;
    private final short failed = 1;

    /**
     * Initializes a newly created instance to represent a status of JUnit 5 execution.
     *
     * @param testExecutionSummary the report provided by {@link SummaryGeneratingListener}
     */
    public Junit5Status(TestExecutionSummary testExecutionSummary) {
        this.summary = testExecutionSummary;
    }

    @Override
    public final short code() {
        return this.summary.getTotalFailureCount() == 0 ? this.passed : this.failed;
    }

    @Override
    public final int runCount() {
        return Math.toIntExact(this.summary.getTestsFoundCount());
    }

    @Override
    public final int failureCount() {
        return Math.toIntExact(this.summary.getTestsFailedCount());
    }

    @Override
    public final int ignoreCount() {
        return Math.toIntExact(this.summary.getTestsSkippedCount());
    }
}
