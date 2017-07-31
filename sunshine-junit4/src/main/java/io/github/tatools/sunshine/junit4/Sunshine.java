package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.*;


/**
 * The {@link Sunshine} class is a main class to run Junit4 tests.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class Sunshine {

    public static void main(String[] args) throws EngineException {
        new Junit4Engine(
                new JunitSuite(
                        new FileSystemOfClasspathClasses(),
                        new RegexCondition(
                                new AttributeWithPrintableValue(
                                        "The following pattern will be used for classes filtering:",
                                        new AttributeFromSequence(
                                                new AttributeOfTestPatternFromCli(),
                                                new AttributeOfTestPatternFromConfig(new ConfigFromSunshine())
                                        )
                                )
                        )
                )
        ).run();
    }
}
