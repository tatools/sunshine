package io.github.tatools.sunshine;

import org.testng.ITestNGListener;
import org.testng.TestNG;

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
    private final TestNGConfiguration configuration;
    private final TestNGSuite tests;

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner with switched off default listeners.
     *
     * @param tests - an instance of a {@link TestNGSuite} where need to find tests
     */
    public TestNGEngine(TestNGSuite tests) {
        this(tests, new TestNGConfiguration.Empty());
    }

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner with will be configured with given configuration.
     *
     * @param tests         - an instance of a {@link TestNGSuite} where need to find tests
     * @param configuration - an instance of {@link TestNGConfiguration}
     */
    public TestNGEngine(TestNGSuite tests, TestNGConfiguration configuration) {
        this(new TestNG(false), configuration, tests);
    }

    private TestNGEngine(TestNG engine, TestNGConfiguration configuration, TestNGSuite tests) {
        this.engine = engine;
        this.configuration = configuration;
        this.tests = tests;
    }

    @Override
    public void run() {
        configuration.apply(engine);
        engine.setTestSuites(Collections.singletonList(tests.tests().path().toString()));
        engine.run();
        System.exit(engine.getStatus());
    }

    @Override
    public TestNGEngine with(ITestNGListener... listeners) {
        final TestNG testNG = new TestNG(false);
        Arrays.stream(listeners).forEach(testNG::addListener);
        return new TestNGEngine(testNG, configuration, tests);
    }
}
