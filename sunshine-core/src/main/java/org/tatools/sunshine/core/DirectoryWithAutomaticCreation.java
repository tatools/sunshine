package org.tatools.sunshine.core;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DirectoryWithAutomaticCreation implements Directory {

    private final Directory directory;

    public DirectoryWithAutomaticCreation(Directory directory) {
        this.directory = directory;
    }

    @Override
    public final void create() throws IOException {
        this.directory.create();
    }

    @Override
    public final void remove() throws IOException {
        this.directory.remove();
    }

    @Override
    public final Path path() {
        try {
            this.create();
            return this.directory.path();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final boolean exist() {
        try {
            this.create();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
