package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;

/**
 * The {@link Sunshine} class is a main class to run TestNG tests.
 * <p>If no arguments will be provided, then Sunshine will try to find TestNG tests in the CLASSPATH.</p>
 * <p>If an argument will be provided, then Sunshine will run TestNG with given argument.
 * The argument is a path to TestNG configuration file (XML or YAML).</p>
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public final class Sunshine {

    public static void main(String[] args) throws EngineException {
        if (args != null && args.length > 0) {
            new TestNGEngine(new PreparedTestNGSuite(args[0])).run();
        } else {
            final Config config = new ConfigFromSunshine();
            new TestNGEngine(
                    new CachedTestNGSuite(
                            new LoadableTestNGSuite(
                                    new FileSystemOfClasspathClasses(),
                                    new DirectoryWithAutomaticCreation(
                                            new DirectoryWithAutomaticDeletion(
                                                    new DirectorySafe(
                                                            new AttributeOfReportFolder(config)
                                                    )
                                            )
                                    ),
                                    new RegexCondition(
                                            new AttributeFromSequence(
                                                    new AttributeOfTestPatternFromCli(),
                                                    new AttributeOfTestPatternFromConfig(config)
                                            )
                                    )
                            )
                    )
            ).run();
        }
    }
}
