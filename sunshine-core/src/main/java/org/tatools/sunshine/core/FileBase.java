package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public class FileBase implements File {

    private final FileSystemPath fileSystemPath;

    public FileBase(Directory directory, String file) {
        this(new FileSystemPathBase(directory, file));
    }

    public FileBase(String directory, String file) {
        this(new FileSystemPathBase(directory, file));
    }

    public FileBase(Path directory, String file) {
        this(new FileSystemPathBase(directory, file));
    }

    public FileBase(FileSystemPath fileSystemPath) {
        this.fileSystemPath = fileSystemPath;
    }

    @Override
    public final Path path() {
        return fileSystemPath.path();
    }

    @Override
    public final boolean exist() {
        return fileSystemPath.exist();
    }

    @Override
    public final void write(String data) throws IOException {
        Files.write(this.path(), data.getBytes());
    }
}
