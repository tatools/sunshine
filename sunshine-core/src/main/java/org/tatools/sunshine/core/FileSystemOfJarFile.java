package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The {@link FileSystemOfJarFile} class allows to search files in given <b>jar</b> file.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
final class FileSystemOfJarFile implements FileSystem {

    private final String jarPath;

    FileSystemOfJarFile(FileSystemPath jarPath) {
        this(jarPath.path().toString());
    }

    FileSystemOfJarFile(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    public List<FileSystemPath> files() throws FileSystemException {
        try {
            List<FileSystemPath> data = new ArrayList<>();
            ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
            for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                data.add(new FileSystemPathBase(entry.getName()));
            }
            return data;
        } catch (IOException e) {
            throw new FileSystemException(e);
        }
    }
}
