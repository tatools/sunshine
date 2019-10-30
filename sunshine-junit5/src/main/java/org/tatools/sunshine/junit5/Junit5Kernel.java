package org.tatools.sunshine.junit5;

import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.tatools.sunshine.core.*;

/**
 * The class provides a {@link Kernel} implementation of JUnit 5 runner.
 *
 * @author Dmytro Serdiuk
 * @version $Id$
 */
public class Junit5Kernel implements Kernel<TestExecutionListener> {

    private final Launcher launcher;
    private final SunshineSuite tests;
    private final SummaryGeneratingListener reporter;

    /**
     * Initializes a newly created {@link Junit5Kernel} object so that it represents
     * an JUnit4 runner.
     *
     * @param sunshineSuite the suite with desired tests
     */
    public Junit5Kernel(SunshineSuite sunshineSuite) {
        this(LauncherFactory.create(), sunshineSuite);
    }

    /**
     * Initializes a newly created {@link Junit5Kernel} object so that it represents
     * an JUnit4 runner.
     *
     * @param launcher the launcher for a given test suite
     * @param sunshineSuite the suite with desired tests
     */
    private Junit5Kernel(Launcher launcher, SunshineSuite sunshineSuite) {
        this.tests = sunshineSuite;
        this.launcher = launcher;
        this.reporter = new SummaryGeneratingListener();
        this.launcher.registerTestExecutionListeners(this.reporter);
    }

    /**
     * Returns a status of JUnite 5 tests execution.
     *
     * @return the status for the current execution
     * @throws KernelException if any error occurs during JUnit tests execution
     */
    @Override
    public final Status status() throws KernelException {
        try {
            launcher.execute(
                    LauncherDiscoveryRequestBuilder.request()
                            .selectors(
                                    tests.tests().stream().map(
                                            sunshineTest -> DiscoverySelectors.selectClass(sunshineTest.toString())
                                    ).toArray(DiscoverySelector[]::new)
                            ).build()
            );
            return new Junit5Status(this.reporter.getSummary());
        } catch (SuiteException e) {
            throw new KernelException("Some problem occurs in the Junit5Kernel", e);
        }
    }

    /**
     * Returns a new instance of the JUnit 5 kernel with provided listeners based
     * on the current instance configuration.
     *
     * @param testExecutionListeners at least one desired listener
     * @return the new instance of the JUnit 5 kernel
     */
    @Override
    public final Kernel<TestExecutionListener> with(TestExecutionListener... testExecutionListeners) {
        final Launcher fork = LauncherFactory.create();
        fork.registerTestExecutionListeners(testExecutionListeners);
        return new Junit5Kernel(fork, this.tests);
    }
}
