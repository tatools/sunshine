package io.github.tatools.sunshine.core;

/**
 * The {@link Kernel} interface declares a way to implement different xnit test runners.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public interface Kernel<Listener> {

    /**
     * Provides information about tests run.
     *
     * @return the status of a tests run
     * @throws KernelException if any error occurs
     */
    Status status() throws KernelException;

    /**
     * Returns new instance of a kernel with provided listeners.
     *
     * @param listeners an instance (or instances) of kernel's listeners
     * @return the new instance of a kernel
     */
    Kernel<Listener> with(Listener... listeners);

    final class Fake implements Kernel {

        private final Status result;

        public Fake(Status status) {
            this.result = status;
        }

        @Override
        public Status status() {
            return this.result;
        }

        @Override
        public Kernel<?> with(Object[] objects) {
            return null;
        }
    }
}
