package io.github.tatools.sunshine;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
@ToString(of = {"artifactPath"})
final class Artifact {
    private final String fromPath;
    private final String artifactPath;

    Artifact(String fromPath, String artifactPath) {
        this.fromPath = fromPath;
        this.artifactPath = artifactPath;
    }

    Artifact(String relativePath) {
        this("", relativePath);
    }

    String asString() {
        if (fromPath.isEmpty()) return artifactPath;
        if (fromPath.equals(artifactPath)) return artifactPath;
        if (fromPath.endsWith("/")) {
            return artifactPath.substring(fromPath.length());
        }
        return artifactPath.substring(fromPath.length() + 1);
    }
}
