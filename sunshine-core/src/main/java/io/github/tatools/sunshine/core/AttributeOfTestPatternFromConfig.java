package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public final class AttributeOfTestPatternFromConfig implements Attribute {

    private final String key = "tests-pattern";
    private final Config config;

    public AttributeOfTestPatternFromConfig(Config config) {
        this.config = config;
    }

    @Override
    public String value() {
        return config.attribute(key);
    }

    @Override
    public boolean present() {
        return config.has(key);
    }
}
