package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
@EqualsAndHashCode
public class RegularPath implements FsPath {

    private final Path directory;
    private final String file;

    public RegularPath(String path) {
        this(Paths.get(path));
    }

    public RegularPath(String directory, String file) {
        this(Paths.get(directory), file);
    }

    public RegularPath(Path path) {
        this(path, "");
    }

    public RegularPath(Directory directory, String fsPath) {
        this(directory.path(), fsPath);
    }

    public RegularPath(Path directory, String file) {
        this.directory = directory;
        this.file = file;
    }

    @Override
    public Path path() {
        return directory.resolve(file);
    }

    @Override
    public boolean exist() {
        return Files.exists(path());
    }
}
