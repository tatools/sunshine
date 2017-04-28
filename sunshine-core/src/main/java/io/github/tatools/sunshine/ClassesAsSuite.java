package io.github.tatools.sunshine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 20.03.2017
 */
final class ClassesAsSuite implements Suite<List<Test<Class>>> {
    private final Location location;

    ClassesAsSuite(Location location) {
        this.location = location;
    }

    @Override
    public List<Test<Class>> tests() {
        return classes(location, new ArrayList<>());
    }

    private List<Test<Class>> classes(Location location, List<Test<Class>> result) {
        for (Artifact file : location.files()) {
            String path = file.asString();
            if (isClass(path)) {
                result.add(new ClassAsTest(path));
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
