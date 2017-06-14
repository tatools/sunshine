package io.github.tatools.sunshine.core;

/**
 * The {@link SuiteException} class is a default exception to handle errors which may occur in the implementations of
 * a {@link Suite}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SuiteException extends SunshineException {
    public SuiteException(String message) {
        super(message);
    }

    public SuiteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuiteException(Throwable cause) {
        super(cause);
    }
}
