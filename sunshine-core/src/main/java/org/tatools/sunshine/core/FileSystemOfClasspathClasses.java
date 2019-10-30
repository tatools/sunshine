package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link FileSystemOfClasspathClasses} class provides an implementation of {@link FileSystem} interface
 * which allows to find all Java classes in current Java CLASSPATH.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public class FileSystemOfClasspathClasses implements FileSystem {

    private final FileSystem fileSystem;

    public FileSystemOfClasspathClasses() {
        this(
                new FileSystemOfClasses(
                        new FileSystemOfFileSystems(
                                Arrays.stream(System.getProperty("java.class.path").split(File.pathSeparator))
                                        .map(FileSystemOfPath::new).collect(Collectors.toList())
                        )
                )
        );
    }

    private FileSystemOfClasspathClasses(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    @Override
    public final List<FileSystemPath> files() throws FileSystemException {
        return fileSystem.files();
    }
}
