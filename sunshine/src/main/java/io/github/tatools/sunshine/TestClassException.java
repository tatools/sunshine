package io.github.tatools.sunshine;

/**
 * The {@link TestClassException} class represents an unchecked exception to handle errors
 * in the {@link ClassAsTest} implementation.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class TestClassException extends RuntimeException {
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
