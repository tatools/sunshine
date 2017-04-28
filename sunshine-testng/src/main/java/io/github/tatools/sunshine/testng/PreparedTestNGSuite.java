package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.FsPath;
import io.github.tatools.sunshine.core.RegularPath;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public final class PreparedTestNGSuite implements TestNGSuite {

    private final FsPath fsPath;

    public PreparedTestNGSuite(String path) {
        this(new RegularPath(path));
    }

    public PreparedTestNGSuite(FsPath fsPath) {
        this.fsPath = fsPath;
    }

    @Override
    public FsPath tests() {
        return fsPath;
    }
}
