package io.github.tatools.sunshine.core;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 20.03.2017
 */
public final class BaseSuite implements SunshineSuite {
    private final Filesystem filesystem;

    public BaseSuite(Filesystem filesystem) {
        this.filesystem = filesystem;
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        return classes(filesystem, new ArrayList<>());
    }

    private List<SunshineTest> classes(Filesystem filesystem, List<SunshineTest> result) throws SuiteException {
        for (FsPath file : filesystem.files()) {
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
