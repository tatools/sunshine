package org.tatools.sunshine.core;

import java.util.List;

/**
 * The class represents several {@link Status}es as a single instance.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class CompositeStatus implements Status {

    private final List<Status> sources;

    /**
     * Constructs a new instance.
     *
     * @param statuses available statuses
     */
    public CompositeStatus(List<Status> statuses) {
        this.sources = statuses;
    }

    /**
     * Returns the exit code of an execution provided by xunit tests runner.
     *
     * <p>The code will be a maximum value from all available codes expect zero ones. If there is no
     * maximal value, 0 is given (means all are passed), otherwise, a non-zero number (if there is
     * at least one failure).
     *
     * @return a calculated exit code
     */
    @Override
    public final short code() {
        return this.sources.stream()
                .map(Status::code)
                .filter(code -> code != 0)
                .max(Short::compareTo)
                .orElse((short) 0);
    }

    /**
     * Returns a sum of all tests of all statuses.
     *
     * @return a count of total tests
     */
    @Override
    public final int runCount() {
        return this.sources.stream().mapToInt(Status::runCount).sum();
    }

    /**
     * Returns a sum of failed tests of all statuses.
     *
     * @return a count of failed tests
     */
    @Override
    public final int failureCount() {
        return this.sources.stream().mapToInt(Status::failureCount).sum();
    }

    /**
     * Returns a sum of ignored tests of all statuses.
     *
     * @return a count of ignored tests
     */
    @Override
    public final int ignoreCount() {
        return this.sources.stream().mapToInt(Status::ignoreCount).sum();
    }
}
