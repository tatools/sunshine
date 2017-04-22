package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public final class PreparedTestNGSuite implements TestNGSuite {

    private final File file;

    public PreparedTestNGSuite(String path) {
        this(new RegularFile(path));
    }

    public PreparedTestNGSuite(File file) {
        this.file = file;
    }

    @Override
    public File tests() {
        return file;
    }
}
