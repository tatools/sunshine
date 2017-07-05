package io.github.tatools.sunshine.core;


import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
@EqualsAndHashCode
public final class ConfigFromClasspathFile implements Config {

    private final Config config;

    public ConfigFromClasspathFile(String file) {
        config = new ConfigFromFile(ClassLoader.getSystemResourceAsStream(file));
    }

    @Override
    public String attribute(String key) {
        return config.attribute(key);
    }

    @Override
    public boolean has(String key) {
        return config.has(key);
    }
}
