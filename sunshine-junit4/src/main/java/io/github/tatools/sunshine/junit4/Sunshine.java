package io.github.tatools.sunshine.junit4;


import io.github.tatools.sunshine.core.RegexCondition;
import io.github.tatools.sunshine.core.Sun;
import io.github.tatools.sunshine.core.VerboseRegex;

/**
 * The {@link Sunshine} class is a main class to run Junit4 tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class Sunshine {

    public static void main(String[] args) {
        new Sun(new Junit4Kernel(new JunitSuite(new VerboseRegex(new RegexCondition())))).shine();
    }
}
