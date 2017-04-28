package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link Classpath} class provides an implementation of {@link Location} interface
 * which allows to find {@link Artifact}s in current Java CLASSPATH.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
public class Classpath implements Location {
    @Override
    public List<Artifact> files() {
        return new CompositeLocation(
                Arrays.stream(System.getProperty("java.class.path").split(File.pathSeparator))
                        .map(Filesystem::new).collect(Collectors.toList())
        ).files();
    }
}
