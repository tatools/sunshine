package io.github.tatools.sunshine.core;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 20.03.2017
 */
public final class BaseSuite implements SunshineSuite {
    private final Location location;

    public BaseSuite(Location location) {
        this.location = location;
    }

    @Override
    public List<SunshineTest> tests() {
        return classes(location, new ArrayList<>());
    }

    private List<SunshineTest> classes(Location location, List<SunshineTest> result) {
        for (FsPath file : location.files()) {
            String path = file.path().toString();
            if (isClass(path)) {
                result.add(new BaseTest(path));
            } else if (isJar(path)) {
                classes(new JarFile(path), result);
            }
        }
        return result;
    }

    private boolean isClass(String path) {
        return path.matches(".+\\.class$") && !path.contains("$");
    }

    private boolean isJar(String path) {
        return path.endsWith(".jar");
    }
}
