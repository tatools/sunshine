package io.github.tatools.sunshine.core;

/**
 * The {@link SunshineJunit4} class is a main class to run Junit4 tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @todo #23:2h Add ability to generate jnit xmls by default
 * @since 18.03.2017
 */
public class SunshineJunit4 {

    public static void main(String[] args) {
        new Junit4Engine(new JunitSuite(new Classpath(), new SunshineTestsFilter(new SunshineConfig()))).run();
    }
}
