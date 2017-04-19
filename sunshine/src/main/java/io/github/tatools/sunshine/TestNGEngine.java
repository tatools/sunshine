package io.github.tatools.sunshine;

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
    private final TestNGConfiguration configuration;
    private final TestNGSuite tests;

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner with switched off default listeners.
     *
     * @param reportsFolder a path where TestNG will store the reports
     * @param tests         an instance of a {@link TestNGSuite} where need to find tests
     */
    public TestNGEngine(Path reportsFolder, TestNGSuite tests) {
        this(reportsFolder, tests, new TestNGConfiguration.Empty());
    }

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner with will be configured with given configuration.
     *
     * @param reportsFolder a path where TestNG will store the reports
     * @param tests         an instance of a {@link TestNGSuite} where need to find tests
     * @param configuration an instance of {@link TestNGConfiguration}
     */
    public TestNGEngine(Path reportsFolder, TestNGSuite tests, TestNGConfiguration configuration) {
        this(new TestNG(false), reportsFolder, configuration, tests);
    }

    private TestNGEngine(TestNG engine, Path reportsFolder, TestNGConfiguration configuration, TestNGSuite tests) {
        this.engine = engine;
        this.reportsFolder = reportsFolder;
        this.configuration = configuration;
        this.tests = tests;
    }

    @Override
    public void run() {
        configuration.apply(engine);
        engine.setOutputDirectory(reportsFolder.toString());
        engine.setTestSuites(Collections.singletonList(tests.tests().path().toString()));
        engine.run();
        System.exit(engine.getStatus());
    }

    @Override
    public TestNGEngine with(ITestNGListener... listeners) {
        final TestNG testNG = new TestNG(false);
        Arrays.stream(listeners).forEach(testNG::addListener);
        return new TestNGEngine(testNG, reportsFolder, configuration, tests);
    }
}
