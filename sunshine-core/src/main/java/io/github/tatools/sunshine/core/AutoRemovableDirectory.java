package io.github.tatools.sunshine.core;


import java.io.IOException;
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
    public void create() throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread("ds") {
            @Override
            public void run() {
                try {
                    directory.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        directory.create();
    }

    @Override
    public void remove() throws IOException {
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
