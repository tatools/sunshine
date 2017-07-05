package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.FileSystemPath;
import io.github.tatools.sunshine.core.Suite;
import io.github.tatools.sunshine.core.SuiteException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public interface TestNGSuite extends Suite<FileSystemPath> {
    /**
     * Return a TestNG tests file.
     *
     * @return an instance of {@link FileSystemPath}.
     * @throws SuiteException if some error occurs
     */
    @Override
    FileSystemPath tests() throws SuiteException;
}
