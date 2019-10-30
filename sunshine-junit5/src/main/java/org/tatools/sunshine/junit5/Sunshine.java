package org.tatools.sunshine.junit5;


import org.tatools.sunshine.core.*;

/**
 * The {@link Sunshine} class is a main class to run JUnit 5 tests.
 *
 * @author Dmytro Serdiuk
 * @version $Id$
 */
public final class Sunshine {

    public static void main(String[] args) {
        new Sun(
                new Junit5Kernel(
                        new SunshineSuitePrintable(
                                new SunshineSuiteFilterable(
                                        new SuiteFromFileSystem(
                                                new FileSystemOfClasspathClasses()
                                        ),
                                        new VerboseRegex(new RegexCondition())
                                )
                        )
                )
        ).shine();
    }
}
