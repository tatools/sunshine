package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link CompositeLocation} class allows to represent several locations as an instance of
 * {@link Location} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
public class CompositeLocation implements Location {
    private final List<Location> locations;

    public CompositeLocation(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public List<Artifact> files() {
        List<Artifact> files = new ArrayList<>();
        for (Location location : locations) {
            files.addAll(location.files());
        }
        return files;
    }
}
