package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link FileSystemOfJarFiles} class allows to convert a file system with JARs only to a file system with files.
 * Basically, it unzips files from the JARs and represents them as a separate file system.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.06.2017
 */
@EqualsAndHashCode
final class FileSystemOfJarFiles implements FileSystem {

    private final FileSystem fileSystem;
    private final Mapping mapping;

    FileSystemOfJarFiles(FileSystem fileSystem) {
        this(fileSystem, fs -> fs.files().stream().map(FileSystemOfJarFile::new).collect(Collectors.toList()));
    }

    private FileSystemOfJarFiles(FileSystem fileSystem, Mapping mapping) {
        this.fileSystem = fileSystem;
        this.mapping = mapping;
    }

    @Override
    public List<FileSystemPath> files() throws FileSystemException {
        return new FileSystemOfFileSystems(mapping.objects(fileSystem)).files();
    }


    @FunctionalInterface
    private interface Mapping {
        List<FileSystem> objects(FileSystem fileSystem) throws FileSystemException;
    }
}
