package org.tatools.sunshine.core;

/**
 * The {@link TestException} class is a default exception to handle errors which may occur in the implementations of
 * a {@link Test} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TestException extends SunshineException {
    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestException(Throwable cause) {
        super(cause);
    }
}
