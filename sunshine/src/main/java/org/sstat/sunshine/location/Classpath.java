package org.sstat.sunshine.location;

import org.sstat.sunshine.Artifact;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class Classpath implements Location {
    @Override
    public List<Artifact> files() {
        return new CompositeLocation(
                Arrays.stream(System.getProperty("java.class.path").split(File.pathSeparator))
                        .map(Path::new).collect(Collectors.toList())
        ).files();
    }
}
