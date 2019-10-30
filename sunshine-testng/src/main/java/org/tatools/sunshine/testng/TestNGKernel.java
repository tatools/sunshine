package org.tatools.sunshine.testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.tatools.sunshine.core.*;
import org.testng.ISuite;
import org.testng.ITestNGListener;
import org.testng.TestNG;

/**
 * The {@link TestNGKernel} class allows to run TestNG for given {@link FileSystem}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class TestNGKernel implements Kernel<ITestNGListener> {

    private final TestNG engine;
    private final TestNGSuite suite;
    private final List<ISuite> suites;

    /**
     * Initializes a newly created {@link TestNGKernel} object so that it represents an TestNG
     * runner.
     *
     * @param tests an instance of a {@link TestNGSuite} where need to find tests
     */
    public TestNGKernel(TestNGSuite tests) {
        this.suites = new ArrayList<>();
        this.engine = new SunshineTestNG(this.suites);
        this.suite = tests;
    }

    @Override
    public final Status status() throws KernelException {
        try {
            this.suites.clear();
            this.engine.setTestSuites(
                    Collections.singletonList(this.suite.tests().path().toString()));
            this.engine.run();
            return new TestNGStatus(engine.getStatus(), this.suites);
        } catch (SuiteException e) {
            throw new KernelException("Some problem occurs in the TestNGKernel", e);
        }
    }

    /**
     * Constructs new {@link TestNGKernel} object with wanted listeners.
     *
     * @param listeners an instance (or instances) of engine's listeners
     * @return an instance of {@link TestNGKernel}
     */
    @Override
    public final TestNGKernel with(ITestNGListener... listeners) {
        final TestNGKernel kernel = new TestNGKernel(this.suite);
        Arrays.stream(listeners).forEach(kernel.engine::addListener);
        return kernel;
    }
}
