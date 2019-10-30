package org.tatools.sunshine.core;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;

/**
 * The {@link FileSystemOfPath} class allows to search files by given path.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
final class FileSystemOfPath implements FileSystem {
    private final Path path;

    FileSystemOfPath(String path) {
        this(new FileSystemPathBase(path).path());
    }

    FileSystemOfPath(Path path) {
        this.path = path;
    }

    @Override
    public List<FileSystemPath> files() throws FileSystemException {
        try {
            List<FileSystemPath> files = new ArrayList<>();
            Files.walkFileTree(
                    path,
                    new FileVisitor<Path>() {
                        @Override
                        public FileVisitResult preVisitDirectory(
                                Path dir, BasicFileAttributes attrs) {
                            files.add(new FileSystemPathRelative(path, dir.toString()));
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            files.add(new FileSystemPathRelative(path, file.toString()));
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException exc) {
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                            return FileVisitResult.CONTINUE;
                        }
                    });
            return files;
        } catch (IOException e) {
            throw new FileSystemException(e);
        }
    }
}
