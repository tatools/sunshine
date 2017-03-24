package io.github.tatools.sunshine;

/**
 * The {@link SunshineTestNG} class is a main class to run TestNG tests.
 * <p>If no arguments will be provided, then Sunshine will try to find TestNG tests in the CLASSPATH.</p>
 * <p>If an argument will be provided, then Sunshine will run TestNG with given argument.
 * The argument is a path to TestNG configuration file (XML or YAML).</p>
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class SunshineTestNG {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            new TestNGXmlRunner(args[0]).run();
        } else {
            new TestNGLocationRunner(new Classpath()).run();
        }
    }
}
