package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public final class ConfigFromSunshine implements Config {

    private final Config config;

    public ConfigFromSunshine() {
        this.config = new ConfigFromClasspathFile("sunshine.properties");
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
