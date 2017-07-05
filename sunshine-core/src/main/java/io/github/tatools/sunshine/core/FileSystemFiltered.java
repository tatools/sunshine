package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link FileSystemFiltered} class allows to filter files by given condition.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.06.2017
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
