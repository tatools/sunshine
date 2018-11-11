package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
@ToString
public final class FileSystemPathBase implements FileSystemPath {

    private final Path directory;
    private final String file;

    public FileSystemPathBase(String path) {
        this(Paths.get(path));
    }

    public FileSystemPathBase(String directory, String file) {
        this(Paths.get(directory), file);
    }

    public FileSystemPathBase(Path path) {
        this(path, "");
    }

    public FileSystemPathBase(Directory directory, String fsPath) {
        this(directory.path(), fsPath);
    }

    public FileSystemPathBase(Path directory, String file) {
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
