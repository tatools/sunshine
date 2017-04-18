package io.github.tatools.sunshine;

/**
 * The {@link SunshineTestNG} class is a main class to run TestNG tests.
 * <p>If no arguments will be provided, then Sunshine will try to find TestNG tests in the CLASSPATH.</p>
 * <p>If an argument will be provided, then Sunshine will run TestNG with given argument.
 * The argument is a path to TestNG configuration file (XML or YAML).</p>
 * <p>The default configuration of TestNG engine is following:
 * <br>- {@link TestNGProduceJunitXml}
 * <br>- {@link TestNGChangeOutputsDirectory} to '{@value SunshineTestNG#TESTS_OUTPUTS}'
 * </p>
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SunshineTestNG {

    // @todo #23:3h Move to property file. It allow to reuse this value for all engines.
    private static final String TESTS_OUTPUTS = "./tests-outputs";

    public static void main(String[] args) {
        TestNGConfiguration configuration = new TestNGCompositeConfiguration(
                new TestNGProduceJunitXml(),
                new TestNGChangeOutputsDirectory(TESTS_OUTPUTS)
        );
        if (args != null && args.length > 0) {
            new TestNGXmlRunner(args[0], configuration).run();
        } else {
            new TestNGEngine(new TestNGTests(new Classpath()), configuration).run();
        }
    }
}
