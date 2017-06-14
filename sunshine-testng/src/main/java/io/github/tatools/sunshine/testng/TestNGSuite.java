package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.FsPath;
import io.github.tatools.sunshine.core.Suite;
import io.github.tatools.sunshine.core.SuiteException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public interface TestNGSuite extends Suite<FsPath> {
    /**
     * Return a TestNG tests file.
     *
     * @return an instance of {@link FsPath}.
     * @throws SuiteException if some error occurs
     */
    @Override
    FsPath tests() throws SuiteException;
}
