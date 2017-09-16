package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;

/**
 * The {@link Sunshine} class is a main class to run TestNG tests.
 * <p>If no arguments will be provided, then Sunshine will try to find TestNG tests in the CLASSPATH.</p>
 * <p>If an argument will be provided, then Sunshine will run TestNG with given argument.
 * The argument is a path to TestNG configuration file (XML or YAML).</p>
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class Sunshine {

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            new Sun(new TestNGKernel(new PreparedTestNGSuite(args[0]))).shine();
        } else {
            new Sun(
                    new TestNGKernel(
                            new LoadableTestNGSuite(
                                    new FileSystemOfClasspathClasses(),
                                    new RegexCondition(
                                            new AttributeWithPrintableValue(
                                                    "The following pattern will be used for classes filtering:",
                                                    new AttributeFromSequence(
                                                            new AttributeOfTestPatternFromCli(),
                                                            new AttributeOfTestPatternFromConfig(
                                                                    new ConfigFromSunshine()
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            ).shine();
        }
    }
}
