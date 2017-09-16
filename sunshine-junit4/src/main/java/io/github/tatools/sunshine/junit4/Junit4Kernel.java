package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.*;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;

import java.util.Arrays;

/**
 * The class provides a {@link Kernel} implementation of JUnit runner.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class Junit4Kernel implements Kernel<RunListener> {

    private final JUnitCore junit;
    private final Suite<Class<?>[]> suiteForRun;

    /**
     * Initializes a newly created {@link Junit4Kernel} object so that it represents
     * an JUnit4 runner.
     *
     * @param suite the tests suite
     */
    public Junit4Kernel(Suite<Class<?>[]> suite) {
        this(new JUnitCore(), suite);
    }

    private Junit4Kernel(JUnitCore jUnitCore, Suite<Class<?>[]> suite) {
        this.junit = jUnitCore;
        this.suiteForRun = suite;
    }

    /**
     * Returns status of JUnite tests execution.
     *
     * @return the status
     * @throws KernelException if any error occurs during JUnit tests execution.
     */
    @Override
    public Status status() throws KernelException {
        try {
            return new JunitStatus(this.junit.run(new Computer(), this.suiteForRun.tests()));
        } catch (SuiteException e) {
            throw new KernelException("Some problem occurs in the Junit4Kernel", e);
        }
    }

    /**
     * Returns new instance of the JUnit kernel with provided listeners.
     *
     * @param listeners an instance (or instances) of JUnit listeners
     * @return the new instance of the JUnit kernel
     */
    @Override
    public Junit4Kernel with(RunListener... listeners) {
        final JUnitCore jUnitCore = new JUnitCore();
        Arrays.stream(listeners).forEach(jUnitCore::addListener);
        return new Junit4Kernel(jUnitCore, this.suiteForRun);
    }
}
