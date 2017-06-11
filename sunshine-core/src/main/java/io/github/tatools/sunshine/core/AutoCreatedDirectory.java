package io.github.tatools.sunshine.core;

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
    public void create() {
        this.directory.create();
    }

    @Override
    public void remove() {
        this.directory.remove();
    }

    @Override
    public Path path() {
        this.create();
        return this.directory.path();
    }

    @Override
    public boolean exist() {
        this.create();
        return true;
    }
}
