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
public final class RelativePath implements FsPath {
    private final FsPath fromPath;
    private final FsPath artifactPath;

    public RelativePath(Path fromPath, String artifactPath) {
        this(new RegularPath(fromPath), new RegularPath(artifactPath));
    }

    public RelativePath(String fromPath, String artifactPath) {
        this(new RegularPath(fromPath), new RegularPath(artifactPath));
    }

    public RelativePath(FsPath fromPath, FsPath artifactPath) {
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
