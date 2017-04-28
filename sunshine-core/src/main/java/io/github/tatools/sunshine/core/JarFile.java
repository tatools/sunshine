package io.github.tatools.sunshine.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The {@link JarFile} class allows to find {@link Artifact}s in give <b>jar</b> file.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
class JarFile implements Location {
    private final String jarPath;

    public JarFile(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    public List<Artifact> files() {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath))) {
            List<Artifact> data = new ArrayList<>();
            for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                data.add(new Artifact(entry.getName()));
            }
            return data;
        } catch (IOException e) {
            throw new LocationException(e);
        }
    }
}
