package io.github.tatools.sunshine.core;

import java.io.IOException;

/**
 * The interface represents some tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public interface Suite<D> {

    /**
     * Returns tests from the suite.
     *
     * @return a test or tests
     * @throws IOException if some errors occur
     */
    D tests() throws IOException;
}
