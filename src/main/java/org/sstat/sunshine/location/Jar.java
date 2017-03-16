package org.sstat.sunshine.location;

import org.sstat.sunshine.Artifact;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class Jar implements Location {
    private final String jarPath;

    public Jar(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    public List<Artifact> files() {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath))) {
            List<Artifact> data = new ArrayList<>();
            for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                String name = entry.getName();
                if (!name.endsWith("/")) {
                    data.add(new Artifact(name));
                }
            }
            return data;
        } catch (IOException e) {
            throw new LocationException(e);
        }
    }
}
