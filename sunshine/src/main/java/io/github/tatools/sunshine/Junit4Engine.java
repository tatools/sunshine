package io.github.tatools.sunshine;

import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 06.04.2017
 */
public class Junit4Engine implements Engine {

    private final JUnitCore jUnitCore = new JUnitCore();
    private final Tests<Class<?>[]> tests;

    public Junit4Engine(Tests<Class<?>[]> tests) {
        this.tests = tests;
    }

    @Override
    public void run() {
        /*
        @todo #23 Add ability to pass some listeners to JUnitCore.
         */
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
}
