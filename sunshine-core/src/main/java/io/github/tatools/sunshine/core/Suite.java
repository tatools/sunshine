package io.github.tatools.sunshine.core;


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
     * @throws SuiteException if some error occurs
     */
    D tests() throws SuiteException;
}
