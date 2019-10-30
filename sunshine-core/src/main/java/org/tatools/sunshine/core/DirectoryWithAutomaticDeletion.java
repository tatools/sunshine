package org.tatools.sunshine.core;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DirectoryWithAutomaticDeletion implements Directory {

    private final Directory directory;

    public DirectoryWithAutomaticDeletion(Directory directory) {
        this.directory = directory;
    }

    @Override
    public final void create() throws IOException {
        Runtime.getRuntime()
                .addShutdownHook(
                        new Thread("ds") {
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
    public final void remove() throws IOException {
        directory.remove();
    }

    @Override
    public final Path path() {
        return directory.path();
    }

    @Override
    public final boolean exist() {
        return directory.exist();
    }
}
