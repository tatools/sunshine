package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;
import org.testng.reporters.JUnitXMLReporter;

/**
 * The {@link SunshineTestNG} class is a main class to run TestNG tests.
 * <p>If no arguments will be provided, then Sunshine will try to find TestNG tests in the CLASSPATH.</p>
 * <p>If an argument will be provided, then Sunshine will run TestNG with given argument.
 * The argument is a path to TestNG configuration file (XML or YAML).</p>
 * <p>The default configuration of TestNG engine is following:
 * <br>- enabled Junit xml reporting
 * <br>- customized TestNG reports folder
 * </p>
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SunshineTestNG {
    // @todo #46 Rename SunshineTestNG to Sunshine.

    public static void main(String[] args) {
        SunshineConfig config = new SunshineConfig();
        ReportFolder reportFolder = new ReportFolder(config);
        String path = reportFolder.value();
        Directory directory = new SmartDirectory(path);
        directory.remove();
        if (args != null && args.length > 0) {
            new TestNGEngine(directory.path(), new PreparedTestNGSuite(args[0])).with(new JUnitXMLReporter()).run();
        } else {
            new TestNGEngine(
                    directory.path(),
                    new CachedTestNGSuite(
                            new LoadableTestNGSuite(new Classpath(), path, new SunshineTestsFilter(config))
                    )
            ).with(new JUnitXMLReporter()).run();
        }
    }
}
