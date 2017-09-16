package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.Engine;
import io.github.tatools.sunshine.core.EngineException;
import io.github.tatools.sunshine.core.Suite;
import io.github.tatools.sunshine.core.SuiteException;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.util.Arrays;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 * @deprecated since 0.2. Use {@link Junit4Kernel} instead. Please pay attention to {@link Engine#run()}.
 */
@Deprecated
public final class Junit4Engine implements Engine<RunListener> {

    private final JUnitCore jUnitCore;
    private final Suite<Class<?>[]> suite;

    /**
     * Constructs the new instance.
     *
     * @param suite the suite to be used
     * @deprecated since 0.2.
     */
    public Junit4Engine(Suite<Class<?>[]> suite) {
        this(new JUnitCore(), suite);
    }

    private Junit4Engine(JUnitCore jUnitCore, Suite<Class<?>[]> suite) {
        this.jUnitCore = jUnitCore;
        this.suite = suite;
    }

    @Override
    public void run() throws EngineException {
        try {
            Result result = jUnitCore.run(new Computer(), suite.tests());
            System.out.println(
                    String.format(
                            "Total tests run: %s, Failures: %s, Skips: %s",
                            result.getRunCount(),
                            result.getFailureCount(),
                            result.getIgnoreCount()
                    )
            );
            System.exit(result.wasSuccessful() ? 0 : -1);
        } catch (SuiteException e) {
            throw new EngineException("Some problem occurs in the Junit4 engine", e);
        }
    }

    @Override
    public Junit4Engine with(RunListener... listeners) {
        final JUnitCore jUnitCore = new JUnitCore();
        Arrays.stream(listeners).forEach(jUnitCore::addListener);
        return new Junit4Engine(jUnitCore, suite);
    }
}
