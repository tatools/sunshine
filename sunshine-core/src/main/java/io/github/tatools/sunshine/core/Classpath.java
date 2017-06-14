package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link Classpath} class provides an implementation of {@link Filesystem} interface
 * which allows to search files in current Java CLASSPATH.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
public final class Classpath implements Filesystem {
    @Override
    public List<FsPath> files() throws SuiteException {
        return new CompositeFilesystem(
                Arrays.stream(System.getProperty("java.class.path").split(File.pathSeparator))
                        .map(FilesystemFromPath::new).collect(Collectors.toList())
        ).files();
    }
}
