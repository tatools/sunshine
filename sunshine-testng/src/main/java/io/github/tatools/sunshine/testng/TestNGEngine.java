package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.Engine;
import io.github.tatools.sunshine.core.Location;
import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

/**
 * The {@link TestNGEngine} class allows to run TestNG for given {@link Location}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public final class TestNGEngine implements Engine<ITestNGListener> {

    private final TestNG engine;
    private final Path reportsFolder;
    private final TestNGSuite tests;

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner with will be configured with given configuration.
     *
     * @param reportsFolder a path where TestNG will store the reports
     * @param tests         an instance of a {@link TestNGSuite} where need to find tests
     */
    public TestNGEngine(Path reportsFolder, TestNGSuite tests) {
        this(new TestNG(false), reportsFolder, tests);
    }

    private TestNGEngine(TestNG engine, Path reportsFolder, TestNGSuite tests) {
        this.engine = engine;
        this.reportsFolder = reportsFolder;
        this.tests = tests;
    }

    @Override
    public void run() {
        engine.setOutputDirectory(reportsFolder.toString());
        engine.setTestSuites(Collections.singletonList(tests.tests().path().toString()));
        engine.run();
        System.exit(engine.getStatus());
    }

    @Override
    public TestNGEngine with(ITestNGListener... listeners) {
        final TestNG testNG = new TestNG(false);
        Arrays.stream(listeners).forEach(testNG::addListener);
        return new TestNGEngine(testNG, reportsFolder, tests);
    }
}
