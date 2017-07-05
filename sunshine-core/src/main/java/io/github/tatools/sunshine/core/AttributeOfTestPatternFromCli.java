package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
@EqualsAndHashCode
public final class AttributeOfTestPatternFromCli implements Attribute {

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
