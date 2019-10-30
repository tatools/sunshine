package org.tatools.sunshine.junit4;

import org.tatools.sunshine.core.RegexCondition;
import org.tatools.sunshine.core.Sun;
import org.tatools.sunshine.core.VerboseRegex;

/**
 * The {@link Sunshine} class is a main class to run Junit 4 tests.
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
