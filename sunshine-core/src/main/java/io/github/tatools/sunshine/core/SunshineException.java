package io.github.tatools.sunshine.core;

/**
 * The {@link SunshineException} class is a base exception for all Sunshine's exceptions.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SunshineException extends Exception {
    public SunshineException(String message) {
        super(message);
    }

    public SunshineException(String message, Throwable cause) {
        super(message, cause);
    }

    public SunshineException(Throwable cause) {
        super(cause);
    }
}
