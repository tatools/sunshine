package org.tatools.sunshine.testng;

import org.tatools.sunshine.core.FileSystemPath;
import org.tatools.sunshine.core.FileSystemPathBase;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PreparedTestNGSuite implements TestNGSuite {

    private final FileSystemPath fileSystemPath;

    public PreparedTestNGSuite(String path) {
        this(new FileSystemPathBase(path));
    }

    public PreparedTestNGSuite(FileSystemPath fileSystemPath) {
        this.fileSystemPath = fileSystemPath;
    }

    @Override
    public final FileSystemPath tests() {
        return fileSystemPath;
    }
}
