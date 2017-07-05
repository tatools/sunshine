package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.FileSystemPath;
import io.github.tatools.sunshine.core.FileSystemPathBase;
import io.github.tatools.sunshine.core.SuiteException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public final class PreparedTestNGSuite implements TestNGSuite {

    private final FileSystemPath fileSystemPath;

    public PreparedTestNGSuite(String path) {
        this(new FileSystemPathBase(path));
    }

    public PreparedTestNGSuite(FileSystemPath fileSystemPath) {
        this.fileSystemPath = fileSystemPath;
    }

    @Override
    public FileSystemPath tests() throws SuiteException {
        return fileSystemPath;
    }
}
