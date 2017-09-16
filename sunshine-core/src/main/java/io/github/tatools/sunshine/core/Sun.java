package io.github.tatools.sunshine.core;

/**
 * The {@link Sun} class provides an implementation of a {@link Star} especially designed for continuous integration
 * servers. If any errors occur during tests execution, a continuous integration server will fail the job's execution.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public final class Sun implements Star {

    private static final int SUNSHINE_ERROR = 12;
    private final Kernel<?> core;

    /**
     * Constructs the new instance.
     *
     * @param kernel the {@link Kernel}
     */
    public Sun(Kernel<?> kernel) {
        this.core = kernel;
    }

    /**
     * Retrieves a {@link Status} of encapsulated {@link Kernel}. If there are some errors in suite's preparation, the
     * execution will be aborted with exit code #{@value SUNSHINE_ERROR}, otherwise exit code will be provided by
     * appropriate {@link Kernel}.
     */
    @Override
    public void shine() {
        try {
            final Status status = this.core.status();
            System.out.println(
                    new StringBuilder("\n===============================================\n")
                            .append("Total tests run: ")
                            .append(status.runCount())
                            .append(", Failures: ")
                            .append(status.failureCount())
                            .append(", Skips: ")
                            .append(status.ignoreCount())
                            .append("\n===============================================\n")
            );
            System.exit(status.code());
        } catch (KernelException e) {
            e.printStackTrace(System.out);
            System.exit(Sun.SUNSHINE_ERROR);
        }
    }
}
