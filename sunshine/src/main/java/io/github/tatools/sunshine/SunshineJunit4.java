package io.github.tatools.sunshine;

/**
 * The {@link SunshineJunit4} class is a main class to run Junit4 tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SunshineJunit4 {

    private static final String TESTS_OUTPUTS = "./tests-outputs";

    public static void main(String[] args) {
        new Junit4Engine(new JunitTests(new Classpath())).run();
    }
}
