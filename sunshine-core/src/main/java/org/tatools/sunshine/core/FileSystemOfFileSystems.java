package org.tatools.sunshine.core;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;

/**
 * The {@link FileSystemOfFileSystems} class allows to represent several fileSystems as an instance
 * of {@link FileSystem} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
final class FileSystemOfFileSystems implements FileSystem {

    private final FileSystem[] fileSystems;

    FileSystemOfFileSystems(List<FileSystem> fileSystems) {
        this(fileSystems.toArray(new FileSystem[] {}));
    }

    FileSystemOfFileSystems(FileSystem... fileSystems) {
        this.fileSystems = fileSystems;
    }

    @Override
    public List<FileSystemPath> files() throws FileSystemException {
        List<FileSystemPath> files = new ArrayList<>();
        for (FileSystem fileSystem : fileSystems) {
            files.addAll(fileSystem.files());
        }
        return files;
    }
}
