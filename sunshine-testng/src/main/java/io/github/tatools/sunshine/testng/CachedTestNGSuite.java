package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.FileSystemPath;
import io.github.tatools.sunshine.core.SuiteException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class CachedTestNGSuite implements TestNGSuite {

    private final List<FileSystemPath> files = new ArrayList<>(1);
    private final TestNGSuite testNGSuite;

    public CachedTestNGSuite(TestNGSuite testNGSuite) {
        this.testNGSuite = testNGSuite;
    }

    @Override
    public FileSystemPath tests() throws SuiteException {
        if (files.isEmpty()) {
            files.add(testNGSuite.tests());
        }
        return files.get(0);
    }
}
