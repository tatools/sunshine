package io.github.tatools.sunshine.core;


import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 11.06.2017
 */
public final class AutoRemovableDirectory implements Directory {

    private final Directory directory;

    public AutoRemovableDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public void create() {
        Runtime.getRuntime().addShutdownHook(new Thread("ds") {
            @Override
            public void run() {
                directory.remove();
            }
        });
        directory.create();
    }

    @Override
    public void remove() {
        directory.remove();
    }

    @Override
    public Path path() {
        return directory.path();
    }

    @Override
    public boolean exist() {
        return directory.exist();
    }
}
