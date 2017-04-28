package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
public class SystemTestsPattern implements Property<String> {

    private final String key = "tests";

    @Override
    public String value() {
        return System.getProperty(key);
    }

    @Override
    public boolean present() {
        return System.getProperty(key) != null;
    }
}
