package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
@EqualsAndHashCode
public class WritableFile implements File {

    private final FsPath fsPath;

    public WritableFile(Directory directory, String file) {
        this(new RegularPath(directory, file));
    }

    public WritableFile(String directory, String file) {
        this(new RegularPath(directory, file));
    }

    public WritableFile(Path directory, String file) {
        this(new RegularPath(directory, file));
    }

    public WritableFile(FsPath fsPath) {
        this.fsPath = fsPath;
    }

    @Override
    public Path path() {
        return fsPath.path();
    }

    @Override
    public boolean exist() {
        return fsPath.exist();
    }

    @Override
    public void write(String data) {
        try {
            Files.write(this.path(), data.getBytes());
        } catch (IOException e) {
            throw new io.github.tatools.sunshine.core.IOException(e);
        }
    }
}
