package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The class allows communicating with a {@link Directory} object safely. This means it does not touch real file system
 * until it's really needed.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public class DirectorySafe implements Directory {

    private final Directory directory;

    public DirectorySafe(String path) {
        this(new DirectoryBase(path));
    }

    public DirectorySafe(Path path) {
        this(new DirectoryBase(path));
    }

    public DirectorySafe(FileSystemPath path) {
        this(new DirectoryBase(path));
    }

    public DirectorySafe(Directory directory) {
        this.directory = directory;
    }

    @Override
    public final void create() throws IOException {
        if (!directory.exist()) {
            directory.create();
        }
    }

    @Override
    public final void remove() throws IOException {
        if (directory.exist()) {
            directory.remove();
        }
    }

    @Override
    public final boolean exist() {
        return directory.exist();
    }

    @Override
    public final Path path() {
        return directory.path();
    }
}
