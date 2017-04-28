package io.github.tatools.sunshine;

import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 24.04.2017
 */
public interface FsPath {
    Path path();

    boolean exist();
}
