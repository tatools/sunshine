package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The class allows communicating with a {@link Directory} object safely. This means it does not touch real file system
 * until it's really needed.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
@EqualsAndHashCode
public final class DirectorySafe implements Directory {

    private final Directory directory;

    public DirectorySafe(String path) {
        this(new DirectoryBase(path));
    }

    public DirectorySafe(Path path) {
        this(new DirectoryBase(path));
    }

    public DirectorySafe(Property property) {
        this(property.value());
    }


    public DirectorySafe(FileSystemPath path) {
        this(new DirectoryBase(path));
    }

    public DirectorySafe(Directory directory) {
        this.directory = directory;
    }

    @Override
    public void create() throws IOException {
        if (!directory.exist()) {
            directory.create();
        }
    }

    @Override
    public void remove() throws IOException {
        if (directory.exist()) {
            directory.remove();
        }
    }

    @Override
    public boolean exist() {
        return directory.exist();
    }

    @Override
    public Path path() {
        return directory.path();
    }
}
