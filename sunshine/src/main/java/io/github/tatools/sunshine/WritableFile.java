package io.github.tatools.sunshine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @todo #36:20m Extract an interface from this class.
 * @since 19.04.2017
 */
class WritableFile implements File {

    private final File file;

    WritableFile(Directory directory, String file) {
        this(new RegularFile(directory.path(), file));
    }

    WritableFile(String path, String file) {
        this(new RegularFile(path, file));
    }

    WritableFile(Path path, String file) {
        this(new RegularFile(path, file));
    }

    WritableFile(File file) {
        this.file = file;
    }

    void write(String data) {
        try {
            Files.write(path(), data.getBytes());
        } catch (IOException e) {
            throw new io.github.tatools.sunshine.IOException(e);
        }
    }

    @Override
    public Path path() {
        return file.path();
    }
}
