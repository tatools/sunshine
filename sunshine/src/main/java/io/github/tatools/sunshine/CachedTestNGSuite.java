package io.github.tatools.sunshine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public class CachedTestNGSuite implements TestNGSuite {

    private final List<File> files = new ArrayList<>(1);
    private final TestNGSuite testNGSuite;

    public CachedTestNGSuite(TestNGSuite testNGSuite) {
        this.testNGSuite = testNGSuite;
    }

    @Override
    public File tests() {
        if (files.isEmpty()) {
            files.add(testNGSuite.tests());
        }
        return files.get(0);
    }
}
