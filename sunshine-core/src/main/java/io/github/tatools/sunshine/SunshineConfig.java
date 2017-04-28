package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class SunshineConfig implements Config {

    private final Config config;

    public SunshineConfig() {
        this.config = new ClasspathConfig("sunshine.properties");
    }

    @Override
    public String property(String key) {
        return config.property(key);
    }

    @Override
    public boolean has(String key) {
        return config.has(key);
    }
}
