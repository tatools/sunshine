package io.github.tatools.sunshine.core;

import java.util.Arrays;
import java.util.List;

/**
 * The interface declares a place to search tests classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public interface FileSystem {
    /**
     * Returns a list of files within given file system. An implementation may support recursive search or not.
     *
     * @return a list of files
     * @throws FileSystemException if some error occurs
     */
    List<FsPath> files() throws FileSystemException;

    class Fake implements FileSystem {
        private final List<FsPath> files;

        Fake(FsPath... files) {
            this(Arrays.asList(files));
        }

        Fake(List<FsPath> files) {
            this.files = files;
        }

        @Override
        public List<FsPath> files() {
            return files;
        }
    }
}
