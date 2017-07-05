package io.github.tatools.sunshine.core;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public interface Directory extends FileSystemPath {
    void create() throws IOException;

    void remove() throws IOException;

    final class Fake implements Directory {
        private final Path path;
        private final boolean exist;

        public Fake(Path path) {
            this(path, false);
        }

        public Fake(Path path, boolean exist) {
            this.path = path;
            this.exist = exist;
        }

        @Override
        public void create() {

        }

        @Override
        public void remove() {

        }

        @Override
        public Path path() {
            return path;
        }

        @Override
        public boolean exist() {
            return exist;
        }
    }
}
