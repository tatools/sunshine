package io.github.tatools.sunshine;

/**
 * The {@link TestNGConfigurationException} class represents an unchecked exception to handle errors
 * in the implementations of the {@link TestNGConfiguration} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class TestNGConfigurationException extends RuntimeException {

    public TestNGConfigurationException(String message) {
        super(message);
    }

    public TestNGConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestNGConfigurationException(Throwable cause) {
        super(cause);
    }
}
