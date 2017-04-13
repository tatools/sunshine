package io.github.tatools.sunshine;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.Collections;

/**
 * The {@link TestNGEngine} class allows to run TestNG for given {@link Location}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public final class TestNGEngine implements Engine {

    private final TestNG engine = new TestNG();
    private final TestNGConfiguration configuration;
    private final Tests<XmlSuite> tests;

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner with switched off default listeners.
     *
     * @param tests - an instance of a {@link Location} where need to find tests
     */
    public TestNGEngine(Tests<XmlSuite> tests) {
        this(tests, new TestNGSkipDefaultListeners());
    }

    /**
     * Initializes a newly created {@link TestNGEngine} object so that it represents
     * an TestNG runner with will be configured with given configuration.
     *
     * @param tests         - an instance of a {@link Tests} where need to find tests
     * @param configuration - an instance of {@link TestNGConfiguration}
     */
    public TestNGEngine(Tests<XmlSuite> tests, TestNGConfiguration configuration) {
        this.tests = tests;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        configuration.apply(engine);
        engine.setXmlSuites(Collections.singletonList(tests.suite()));
        engine.run();
        System.exit(engine.getStatus());
    }
}
