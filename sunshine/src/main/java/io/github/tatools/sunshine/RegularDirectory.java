package io.github.tatools.sunshine;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public class RegularDirectory implements Directory {

    private final Path path;

    public RegularDirectory(String path) {
        this(Paths.get(path));
    }

    public RegularDirectory(Path path) {
        this.path = path;
    }

    @Override
    public void create() {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            throw new io.github.tatools.sunshine.IOException(e);
        }
    }

    @Override
    public void remove() {
        try {
            Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(java.io.File::delete);
        } catch (IOException e) {
            throw new io.github.tatools.sunshine.IOException(e);
        }
    }

    @Override
    public boolean exist() {
        return Files.exists(path);
    }

    @Override
    public Path path() {
        return path;
    }
}
