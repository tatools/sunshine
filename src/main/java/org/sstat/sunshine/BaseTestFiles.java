package org.sstat.sunshine;

import org.sstat.sunshine.location.Jar;
import org.sstat.sunshine.location.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class BaseTestFiles implements TestFiles {
    private final Location location;

    public BaseTestFiles(Location location) {
        this.location = location;
    }

    @Override
    public List<TestFile> allTests() {
        return testFiles(location, new ArrayList<>());
    }

    private List<TestFile> testFiles(Location location, List<TestFile> result) {
        for (Artifact file : location.files()) {
            String path = file.asString();
            if (isClass(path)) {
                result.add(new BaseTestFile(path));
            } else if (isJar(path)) {
                testFiles(new Jar(path), result);
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
