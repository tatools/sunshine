package org.sstat.sunshine;

import org.testng.TestNG;

import java.util.Collections;

/**
 * The {@link TestNGLocationRunner} class allows to run TestNG for given {@link Location}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public final class TestNGLocationRunner implements Engine {

    private final TestNG engine = new TestNG();
    private final TestNGConfiguration configuration;
    private final Location location;

    /**
     * Initializes a newly created {@link TestNGLocationRunner} object so that it represents
     * an TestNG runner with switched off default listeners.
     *
     * @param location - an instance of a {@link Location} where need to find tests
     */
    public TestNGLocationRunner(Location location) {
        this(location, new SkipDefaultListeners());
    }

    /**
     * Initializes a newly created {@link TestNGLocationRunner} object so that it represents
     * an TestNG runner with will be configured with given configuration.
     *
     * @param location      - an instance of a {@link Location} where need to find tests
     * @param configuration - an instance of {@link TestNGConfiguration}
     */
    public TestNGLocationRunner(Location location, TestNGConfiguration configuration) {
        this.location = location;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        configuration.applyBeforeRun(engine);
        engine.setXmlSuites(Collections.singletonList(new TestNGTests(location).suite()));
        engine.run();
        configuration.applyAfterRun(engine);
        System.exit(engine.getStatus());
    }
}
