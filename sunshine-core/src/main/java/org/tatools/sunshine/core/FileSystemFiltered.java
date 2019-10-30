package org.tatools.sunshine.core;

import java.util.List;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;

/**
 * The {@link FileSystemFiltered} class allows to filter files by given condition.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
final class FileSystemFiltered implements FileSystem {

    private final FileSystem fileSystem;
    private final Condition condition;

    FileSystemFiltered(FileSystem fileSystem, Condition condition) {
        this.fileSystem = fileSystem;
        this.condition = condition;
    }

    @Override
    public List<FileSystemPath> files() throws FileSystemException {
        return fileSystem.files().stream()
                .filter(f -> condition.applicable(f.path().toString()))
                .collect(Collectors.toList());
    }
}
