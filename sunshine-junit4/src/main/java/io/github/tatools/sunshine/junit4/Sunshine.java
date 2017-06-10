package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.Classpath;
import io.github.tatools.sunshine.core.SunshineConfig;
import io.github.tatools.sunshine.core.SunshineTestsFilter;

/**
 * The {@link Sunshine} class is a main class to run Junit4 tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public final class Sunshine {

    public static void main(String[] args) {
        new Junit4Engine(new JunitSuite(new Classpath(), new SunshineTestsFilter(new SunshineConfig()))).run();
    }
}
