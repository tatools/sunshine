package io.github.tatools.sunshine.core;

import java.io.IOException;
import java.util.List;

/**
 * The interface declares a place to search tests classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public interface Location {

    /**
     * Returns a list of files paths. Any implementation has to support recursive search by defined place.
     *
     * @return a list of paths
     * @throws IOException if some errors occur
     */
    List<FsPath> files() throws IOException;


    class Fake implements Location {
        private final List<FsPath> files;

        Fake(List<FsPath> files) {
            this.files = files;
        }

        @Override
        public List<FsPath> files() {
            return files;
        }
    }
}
