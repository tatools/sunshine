package org.sstat.sunshine;

/**
 * The interface represents a class with a test (tests).
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public interface TestFile {

    Class<?> asClass() throws ClassNotFoundException;
}
