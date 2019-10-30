package org.tatools.sunshine.core;

import java.nio.file.Path;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
@ToString(of = {"artifactPath"})
public class FileSystemPathRelative implements FileSystemPath {
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
    public final Path path() {
        if (fromPath.equals(artifactPath)) return artifactPath.path();
        return fromPath.path().relativize(artifactPath.path());
    }

    @Override
    public final boolean exist() {
        throw new UnsupportedOperationException(
                "Can't say definitely about existence of a path: " + path());
    }
}
