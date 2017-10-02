package io.github.tatools.sunshine.core;

import java.util.Arrays;
import java.util.List;

/**
 * The interface declares a place to search tests classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface FileSystem {
    /**
     * Returns a list of files within given file system. An implementation may support recursive search or not.
     *
     * @return a list of files
     * @throws FileSystemException if some error occurs
     */
    List<FileSystemPath> files() throws FileSystemException;

    class Fake implements FileSystem {
        private final List<FileSystemPath> files;

        public Fake(FileSystemPath... files) {
            this(Arrays.asList(files));
        }

        Fake(List<FileSystemPath> files) {
            this.files = files;
        }

        @Override
        public List<FileSystemPath> files() {
            return files;
        }
    }
}
