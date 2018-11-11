package org.tatools.sunshine.testng;

import org.tatools.sunshine.core.FileSystemPath;
import org.tatools.sunshine.core.Suite;
import org.tatools.sunshine.core.SuiteException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
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
