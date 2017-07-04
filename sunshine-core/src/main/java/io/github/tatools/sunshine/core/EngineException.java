package io.github.tatools.sunshine.core;

/**
 * The {@link EngineException} class is a default exception to handle errors which may occur in the implementations of
 * an {@link Engine}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 04.07.2017
 */
public class EngineException extends SunshineException {
    public EngineException(String message) {
        super(message);
    }

    public EngineException(String message, Throwable cause) {
        super(message, cause);
    }

    public EngineException(Throwable cause) {
        super(cause);
    }
}
