package org.tatools.sunshine.core;

/**
 * The interface represents some tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
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
