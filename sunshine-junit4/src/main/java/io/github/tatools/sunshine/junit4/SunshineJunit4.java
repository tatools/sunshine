package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.Classpath;
import io.github.tatools.sunshine.core.SunshineConfig;
import io.github.tatools.sunshine.core.SunshineTestsFilter;

/**
 * The {@link SunshineJunit4} class is a main class to run Junit4 tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SunshineJunit4 {
    // @todo #46:30m Rename SunshineJunit4 to Sunshine.

    public static void main(String[] args) {
         // @todo #23:2h Add ability to generate junit xmls by default. Update javadoc in the class.
        new Junit4Engine(new JunitSuite(new Classpath(), new SunshineTestsFilter(new SunshineConfig()))).run();
    }
}
