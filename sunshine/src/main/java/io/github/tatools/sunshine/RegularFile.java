package io.github.tatools.sunshine;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
class RegularFile implements File {

    private final Path path;
    private final String file;

    RegularFile(String path) {
        this(Paths.get(path), "");
    }

    RegularFile(String path, String file) {
        this(Paths.get(path), file);
    }

    RegularFile(Path path, String file) {
        this.path = path;
        this.file = file;
    }

    @Override
    public Path path() {
        return path.resolve(file);
    }
}
