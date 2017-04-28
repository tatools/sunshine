package io.github.tatools.sunshine.core;

/**
 * The {@link LocationException} class represents an unchecked exception to handle errors
 * in the implementations of the {@link Location} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class LocationException extends RuntimeException {

    public LocationException(String message) {
        super(message);
    }

    public LocationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationException(Throwable cause) {
        super(cause);
    }
}
