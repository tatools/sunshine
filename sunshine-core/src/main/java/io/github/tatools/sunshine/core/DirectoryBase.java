package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public final class DirectoryBase implements Directory {

    private final FileSystemPath fileSystemPath;

    public DirectoryBase(String path) {
        this(new FileSystemPathBase(path));
    }

    public DirectoryBase(Path path) {
        this.fileSystemPath = new FileSystemPathBase(path);
    }

    public DirectoryBase(FileSystemPath fileSystemPath) {
        this.fileSystemPath = fileSystemPath;
    }

    @Override
    public void create() throws IOException {
        Files.createDirectory(fileSystemPath.path());
    }

    @Override
    public void remove() throws IOException {
        Files.walk(fileSystemPath.path(), FileVisitOption.FOLLOW_LINKS)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(java.io.File::delete);
    }

    @Override
    public boolean exist() {
        return fileSystemPath.exist();
    }

    @Override
    public Path path() {
        return fileSystemPath.path();
    }
}
