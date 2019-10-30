package org.tatools.sunshine.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        private final List<Object> listeners;

        /**
         * Constructs a new object. All listeners are stored internally.
         *
         * @param status a status of the execution
         */
        public Fake(Status status) {
            this(status, new ArrayList<>());
        }

        /**
         * Constructs a new object.
         *
         * @param status a status of the execution
         * @param availableListeners a list which will store all listeners
         */
        public Fake(Status status, List<Object> availableListeners) {
            this.result = status;
            this.listeners = availableListeners;
        }

        @Override
        public Status status() {
            return this.result;
        }

        @Override
        public Kernel<?> with(Object... objects) {
            this.listeners.addAll(Arrays.asList(objects));
            return new Fake(this.result, this.listeners);
        }
    }
}
