package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.*;


/**
 * The {@link Sunshine} class is a main class to run Junit4 tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public final class Sunshine {

    public static void main(String[] args) throws SuiteException {
        new Junit4Engine(
                new JunitSuite(
                        new Classpath(),
                        new RegexCondition(
                                new EitherProperty<>(
                                        new SystemTestsPattern(),
                                        new DefaultTestsPattern(new SunshineConfig())
                                )
                        )
                )
        ).run();
    }
}
