package io.github.tatools.sunshine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 20.03.2017
 */
final class TestClasses {
    private final Location location;

    TestClasses(Location location) {
        this.location = location;
    }

    List<TestClass> classes() {
        return classes(location, new ArrayList<>());
    }

    private List<TestClass> classes(Location location, List<TestClass> result) {
        for (Artifact file : location.files()) {
            String path = file.asString();
            if (isClass(path)) {
                result.add(new TestClass(path));
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
