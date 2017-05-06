package io.github.tatools.sunshine.core;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 24.04.2017
 */
public interface FsPath {
    Path path();

    boolean exist();

    final class Fake implements FsPath {

        private final Path path;
        private final boolean exist;

        public Fake() {
            this(Paths.get("."), true);
        }

        public Fake(Path path, boolean exist) {
            this.path = path;
            this.exist = exist;
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
