package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
@EqualsAndHashCode
public final class DefaultTestsPattern implements Property {

    private final String key = "tests-pattern";
    private final Config config;

    public DefaultTestsPattern(Config config) {
        this.config = config;
    }

    @Override
    public String value() {
        return config.property(key);
    }

    @Override
    public boolean present() {
        return config.has(key);
    }
}
