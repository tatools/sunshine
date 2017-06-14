package io.github.tatools.sunshine.core;

import java.util.List;

/**
 * The interface declares a place to search tests classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public interface Location {
    // @todo #90:2h Remove this interface and replace with Suite's implementations.
    /**
     * Returns a list of files paths. Any implementation has to support recursive search by defined place.
     *
     * @return a list of paths
     * @throws SuiteException if some error occurs
     */
    List<FsPath> files() throws SuiteException;


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
