package org.sstat.sunshine;

/**
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
