package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
@ToString(of = {"artifactPath"})
public final class FileSystemPathRelative implements FileSystemPath {
    private final FileSystemPath fromPath;
    private final FileSystemPath artifactPath;

    public FileSystemPathRelative(Path fromPath, String artifactPath) {
        this(new FileSystemPathBase(fromPath), new FileSystemPathBase(artifactPath));
    }

    public FileSystemPathRelative(String fromPath, String artifactPath) {
        this(new FileSystemPathBase(fromPath), new FileSystemPathBase(artifactPath));
    }

    public FileSystemPathRelative(FileSystemPath fromPath, FileSystemPath artifactPath) {
        this.fromPath = fromPath;
        this.artifactPath = artifactPath;
    }

    @Override
    public Path path() {
        if (fromPath.equals(artifactPath)) return artifactPath.path();
        return fromPath.path().relativize(artifactPath.path());
    }

    @Override
    public boolean exist() {
        throw new UnsupportedOperationException("Can't say definitely about existence of a path: " + path());
    }
}
