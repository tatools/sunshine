package io.github.tatools.sunshine;

import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.Arrays;
import java.util.Collections;

/**
 * The {@link TestNGXmlRunner} class allows to run TestNG tests based on provided suite file.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @todo #29:2h We have to remove this engine's impl and move logic to an impl of {@link Tests}.
 * @since 17.03.2017
 */
public final class TestNGXmlRunner implements Engine<ITestNGListener> {

    private final TestNG engine;
    private final TestNGConfiguration configuration;
    private final String suitePath;

    /**
     * Initializes a newly created {@link TestNGXmlRunner} object so that it represents
     * an TestNG runner with switched off default listeners.
     *
     * @param suitePath - a path to TestNG xml or yaml file
     */
    public TestNGXmlRunner(String suitePath) {
        this(suitePath, new TestNGConfiguration.Empty());
    }

    /**
     * Initializes a newly created {@link TestNGXmlRunner} object so that it represents
     * an TestNG runner with will be configured with given configuration.
     *
     * @param suitePath     - a path to TestNG xml or yaml file
     * @param configuration - an instance of {@link TestNGConfiguration}
     */
    public TestNGXmlRunner(String suitePath, TestNGConfiguration configuration) {
        this(new TestNG(false), configuration, suitePath);
    }

    private TestNGXmlRunner(TestNG engine, TestNGConfiguration configuration, String suitePath) {
        this.engine = engine;
        this.configuration = configuration;
        this.suitePath = suitePath;
    }

    @Override
    public void run() {
        configuration.apply(engine);
        engine.setTestSuites(Collections.singletonList(suitePath));
        engine.run();
        System.exit(engine.getStatus());
    }

    @Override
    public TestNGXmlRunner with(ITestNGListener... listeners) {
        final TestNG testNG = new TestNG(false);
        Arrays.stream(listeners).forEach(testNG::addListener);
        return new TestNGXmlRunner(testNG, configuration, suitePath);
    }
}
