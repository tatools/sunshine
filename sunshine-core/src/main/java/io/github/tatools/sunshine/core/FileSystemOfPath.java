package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@link FileSystemOfPath} class allows to search files by given path.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
final class FileSystemOfPath implements FileSystem {
    private final Path path;

    FileSystemOfPath(String path) {
        this(new RegularPath(path).path());
    }

    FileSystemOfPath(Path path) {
        this.path = path;
    }

    @Override
    public List<FsPath> files() throws FileSystemException {
        try {
            List<FsPath> files = new ArrayList<>();
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    files.add(new RelativePath(path, dir.toString()));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    files.add(new RelativePath(path, file.toString()));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
            return files;
        } catch (IOException e) {
            throw new FileSystemException(e);
        }
    }
}
