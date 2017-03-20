package org.sstat.sunshine;

import org.testng.TestNG;

import java.util.Collections;

/**
 * The {@link TestNGXmlRunner} class allows to run TestNG tests based on provided suite file.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public final class TestNGXmlRunner implements Engine {

    private final TestNG engine = new TestNG();
    private final TestNGConfiguration configuration;
    private final String suitePath;

    /**
     * Initializes a newly created {@link TestNGXmlRunner} object so that it represents
     * an TestNG runner with switched off default listeners.
     *
     * @param suitePath - a path to TestNG xml or yaml file
     */
    public TestNGXmlRunner(String suitePath) {
        this(suitePath, new SkipDefaultListeners());
    }

    /**
     * Initializes a newly created {@link TestNGXmlRunner} object so that it represents
     * an TestNG runner with will be configured with given configuration.
     *
     * @param suitePath     - a path to TestNG xml or yaml file
     * @param configuration - an instance of {@link TestNGConfiguration}
     */
    public TestNGXmlRunner(String suitePath, TestNGConfiguration configuration) {
        this.suitePath = suitePath;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        configuration.applyBeforeRun(engine);
        engine.setTestSuites(Collections.singletonList(suitePath));
        engine.run();
        configuration.applyAfterRun(engine);
        System.exit(engine.getStatus());
    }
}
