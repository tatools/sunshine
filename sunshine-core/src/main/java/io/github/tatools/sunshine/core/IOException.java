package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public final class IOException extends RuntimeException {
    /*
    @todo #82:30m Review IOException exception. According to Fail Fast strategy it needs to be checked.
     May it's possible to use standard Java exception instead.
     */

    public IOException(String message) {
        super(message);
    }

    public IOException(String message, Throwable cause) {
        super(message, cause);
    }

    public IOException(Throwable cause) {
        super(cause);
    }
}
