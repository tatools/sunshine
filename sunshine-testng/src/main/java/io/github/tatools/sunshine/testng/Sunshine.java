package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;

import java.io.IOException;

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

    public static void main(String[] args) throws IOException {
        if (args != null && args.length > 0) {
            new TestNGEngine(new PreparedTestNGSuite(args[0])).run();
        } else {
            final SunshineConfig config = new SunshineConfig();
            new TestNGEngine(
                    new CachedTestNGSuite(
                            new LoadableTestNGSuite(
                                    new Classpath(),
                                    new AutoCreatedDirectory(
                                            new AutoRemovableDirectory(
                                                    new SmartDirectory(
                                                            new ReportFolder(config)
                                                    )
                                            )
                                    ),
                                    new RegexCondition(
                                            new EitherProperty<>(
                                                    new SystemTestsPattern(),
                                                    new DefaultTestsPattern(new SunshineConfig())
                                            )
                                    )
                            )
                    )
            ).run();
        }
    }
}
