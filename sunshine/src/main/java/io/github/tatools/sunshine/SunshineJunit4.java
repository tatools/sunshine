package io.github.tatools.sunshine;

/**
 * The {@link SunshineJunit4} class is a main class to run Junit4 tests.
 *
 * @todo #23:2h Add ability to generate jnit xmls by default
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SunshineJunit4 {

    public static void main(String[] args) {
        new Junit4Engine(new JunitTests(new Classpath())).run();
    }
}
