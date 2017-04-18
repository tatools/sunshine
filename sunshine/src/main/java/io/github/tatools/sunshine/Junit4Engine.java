package io.github.tatools.sunshine;

import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.util.Arrays;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 06.04.2017
 */
public class Junit4Engine implements Engine<RunListener> {

    private final JUnitCore jUnitCore;
    private final Tests<Class<?>[]> tests;

    public Junit4Engine(Tests<Class<?>[]> tests) {
        this(new JUnitCore(), tests);
    }

    private Junit4Engine(JUnitCore jUnitCore, Tests<Class<?>[]> tests) {
        this.jUnitCore = jUnitCore;
        this.tests = tests;
    }

    @Override
    public void run() {
        Result result = jUnitCore.run(new Computer(), tests.suite());
        System.out.println(
                String.format(
                        "Total tests run: %s, Failures: %s, Skips: %s",
                        result.getRunCount(),
                        result.getFailureCount(),
                        result.getIgnoreCount()
                )
        );
        System.exit(result.wasSuccessful() ? 0 : -1);
    }

    @Override
    public Junit4Engine with(RunListener... listeners) {
        final JUnitCore jUnitCore = new JUnitCore();
        Arrays.stream(listeners).forEach(jUnitCore::addListener);
        return new Junit4Engine(jUnitCore, tests);
    }
}
