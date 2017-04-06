package io.github.tatools.sunshine;

import org.junit.runner.JUnitCore;

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
        jUnitCore.run(tests.suite());
    }
}
