package org.sstat.sunshine;

import java.util.List;

/**
 * The interface declares a place to search tests classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @see LocationException
 * @since 16.03.2017
 */
public interface Location {

    /**
     * Returns a list of files paths. Any implementation has to support recursive search by defined place.
     *
     * @return a list of paths
     */
    List<Artifact> files();


    class Fake implements Location {
        private final List<Artifact> files;

        Fake(List<Artifact> files) {
            this.files = files;
        }

        @Override
        public List<Artifact> files() {
            return files;
        }
    }
}
