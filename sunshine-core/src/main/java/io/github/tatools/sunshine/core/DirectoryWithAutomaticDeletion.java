package io.github.tatools.sunshine.core;


import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class DirectoryWithAutomaticDeletion implements Directory {

    private final Directory directory;

    public DirectoryWithAutomaticDeletion(Directory directory) {
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
