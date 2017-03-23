package com.softserveinc.sstat.sunshine;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Path} class allows to find {@link Artifact}s by given path.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
class Path implements Location {
    private final String path;

    Path(String path) {
        this.path = path;
    }

    @Override
    public List<Artifact> files() {
        List<Artifact> files = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(path), new FileVisitor<java.nio.file.Path>() {
                @Override
                public FileVisitResult preVisitDirectory(java.nio.file.Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(java.nio.file.Path file, BasicFileAttributes attrs) throws IOException {
                    files.add(new Artifact(path, file.toString()));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(java.nio.file.Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(java.nio.file.Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new LocationException(e);
        }
        return files;
    }
}
