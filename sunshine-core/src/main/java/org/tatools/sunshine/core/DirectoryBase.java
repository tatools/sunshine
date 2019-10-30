package org.tatools.sunshine.core;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public class DirectoryBase implements Directory {

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
    public final void create() throws IOException {
        Files.createDirectory(fileSystemPath.path());
    }

    @Override
    public final void remove() throws IOException {
        Files.walk(fileSystemPath.path(), FileVisitOption.FOLLOW_LINKS)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(java.io.File::delete);
    }

    @Override
    public final boolean exist() {
        return fileSystemPath.exist();
    }

    @Override
    public final Path path() {
        return fileSystemPath.path();
    }
}
