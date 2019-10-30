package org.tatools.sunshine.junit4;

import org.junit.runner.Result;
import org.tatools.sunshine.core.Status;

/**
 * The class provides an implementation of the {@link Status} of JUnit execution.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class JunitStatus implements Status {

    private final Result status;

    /**
     * Initializes a newly created {@link JunitStatus} object so that it represents a status of
     * JUnit 4 execution.
     *
     * @param result the JUnit 4 result
     */
    public JunitStatus(Result result) {
        this.status = result;
    }

    @Override
    public final short code() {
        if (this.status.wasSuccessful()) {
            return (short) 0;
        }
        return (short) 1;
    }

    @Override
    public final int runCount() {
        return status.getRunCount();
    }

    @Override
    public final int failureCount() {
        return status.getFailureCount();
    }

    @Override
    public final int ignoreCount() {
        return status.getIgnoreCount();
    }
}
