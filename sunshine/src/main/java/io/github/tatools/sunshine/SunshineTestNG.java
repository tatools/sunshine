package io.github.tatools.sunshine;

/**
 * The {@link SunshineTestNG} class is a main class to run TestNG tests.
 * <p>If no arguments will be provided, then Sunshine will try to find TestNG tests in the CLASSPATH.</p>
 * <p>If an argument will be provided, then Sunshine will run TestNG with given argument.
 * The argument is a path to TestNG configuration file (XML or YAML).</p>
 * <p>The default configuration of TestNG engine is following:
 * <br>- {@link TestNGProduceJunitXml}
 * </p>
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SunshineTestNG {

    // @todo #23:3h Move to property file. It allow to reuse this value for all engines.
    private static final String TESTS_OUTPUTS = "./tests-outputs";

    public static void main(String[] args) {
        Directory directory = new SmartDirectory(TESTS_OUTPUTS);
        directory.remove();
        if (args != null && args.length > 0) {
            new TestNGEngine(directory.path(), new PreparedTestNGSuite(args[0]), new TestNGProduceJunitXml()).run();
        } else {
            new TestNGEngine(
                    directory.path(),
                    new CachedTestNGSuite(new LoadableTestNGSuite(new Classpath(), TESTS_OUTPUTS)),
                    new TestNGProduceJunitXml()
            ).run();
        }
    }
}
