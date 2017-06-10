package io.github.tatools.sunshine.core;

/**
 * The {@link TestClassException} class represents an unchecked exception to handle errors
 * in the {@link BaseTest} implementation.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public final class TestClassException extends RuntimeException {
    /*
     * @todo #82:30m Review a usage of TestClassException exception. According to Fail Fast strategy it needs to be checked.
     *  And need to decide where it can be handled. Also, it will be great to have a common parent for all Sunshine's
     *  exceptions.
     */
    public TestClassException(String message) {
        super(message);
    }

    public TestClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestClassException(Throwable cause) {
        super(cause);
    }
}
