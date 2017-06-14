package io.github.tatools.sunshine.core;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 11.06.2017
 */
public final class AutoCreatedDirectory implements Directory {

    private final Directory directory;

    public AutoCreatedDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public void create() throws IOException {
        this.directory.create();
    }

    @Override
    public void remove() throws IOException {
        this.directory.remove();
    }

    @Override
    public Path path() {
        try {
            this.create();
            return this.directory.path();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exist() {
        try {
            this.create();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
