package io.github.tatools.sunshine.core;

/**
 * The {@link Status} interface declares a way to retrieve tests run status.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public interface Status {

    /**
     * Returns the exit code of an execution provided by xunit tests runner.
     *
     * @return the exit code
     */
    short code();

    /**
     * Returns a count of tests were run by a xunit runner.
     *
     * @return the count of total tests
     */
    int runCount();

    /**
     * Returns a count of failed tests were run by a xunit runner.
     *
     * @return the count of failed tests
     */
    int failureCount();

    /**
     * Returns a count of ignored or skipped tests were run by a xunit runner.
     *
     * @return the count of ignored tests
     */
    int ignoreCount();

    final class Fake implements Status {
        private final short c;
        private final int r;
        private final int f;
        private final int i;

        public Fake() {
            this((short) 0, 5, 0, 1);
        }

        public Fake(short code, int total, int failed, int ignored) {
            this.c = code;
            this.r = total;
            this.f = failed;
            this.i = ignored;
        }

        @Override
        public short code() {
            return this.c;
        }

        @Override
        public int runCount() {
            return this.r;
        }

        @Override
        public int failureCount() {
            return this.f;
        }

        @Override
        public int ignoreCount() {
            return this.i;
        }
    }
}
