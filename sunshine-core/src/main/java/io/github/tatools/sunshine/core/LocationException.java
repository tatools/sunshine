package io.github.tatools.sunshine.core;

/**
 * The {@link LocationException} class represents an unchecked exception to handle errors
 * in the implementations of the {@link Location} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public final class LocationException extends RuntimeException {
//  @todo #82:30m Review a usage of LocationException exception. According to Fail Fast strategy it needs to be checked.

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
