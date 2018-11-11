package org.tatools.sunshine.core;

/**
 * The {@link KernelException} class is a default exception to handle errors which may occur in the implementations of
 * an {@link Kernel}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class KernelException extends SunshineException {
    public KernelException(String message) {
        super(message);
    }

    public KernelException(String message, Throwable cause) {
        super(message, cause);
    }

    public KernelException(Throwable cause) {
        super(cause);
    }
}
