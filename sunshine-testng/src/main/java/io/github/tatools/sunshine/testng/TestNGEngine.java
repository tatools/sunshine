package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.Engine;
import io.github.tatools.sunshine.core.FileSystem;
import io.github.tatools.sunshine.core.SuiteException;
import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.Arrays;
import java.util.Collections;

/**
 * The {@link TestNGEngine} class allows to run TestNG for given {@link FileSystem}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public final class TestNGEngine implements Engine<ITestNGListener> {

    private final TestNG engine;
    private final TestNGSuite tests;

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner.
     *
     * @param tests an instance of a {@link TestNGSuite} where need to find tests
     */
    public TestNGEngine(TestNGSuite tests) {
        this(new TestNG(false), tests);
    }

    private TestNGEngine(TestNG engine, TestNGSuite tests) {
        this.engine = engine;
        this.tests = tests;
    }

    @Override
    public void run() throws SuiteException {
        engine.setTestSuites(Collections.singletonList(tests.tests().path().toString()));
        engine.run();
        System.exit(engine.getStatus());
    }

    /**
     * Constructs new {@link TestNGEngine} object with wanted listeners.
     *
     * @param listeners an instance (or instances) of engine's listeners
     * @return an instance of {@link TestNGEngine}
     */
    @Override
    public TestNGEngine with(ITestNGListener... listeners) {
        final TestNG testNG = new TestNG(false);
        Arrays.stream(listeners).forEach(testNG::addListener);
        return new TestNGEngine(testNG, tests);
    }
}
