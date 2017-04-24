package io.github.tatools.sunshine;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public class RegularDirectory implements Directory {

    private final FsPath fsPath;

    public RegularDirectory(String path) {
        this(new RegularPath(path));
    }

    public RegularDirectory(Path path) {
        this.fsPath = new RegularPath(path);
    }

    public RegularDirectory(FsPath fsPath) {
        this.fsPath = fsPath;
    }

    @Override
    public void create() {
        try {
            Files.createDirectory(fsPath.path());
        } catch (IOException e) {
            throw new io.github.tatools.sunshine.IOException(e);
        }
    }

    @Override
    public void remove() {
        try {
            Files.walk(fsPath.path(), FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(java.io.File::delete);
        } catch (IOException e) {
            throw new io.github.tatools.sunshine.IOException(e);
        }
    }

    @Override
    public boolean exist() {
        return fsPath.exist();
    }

    @Override
    public Path path() {
        return fsPath.path();
    }
}
