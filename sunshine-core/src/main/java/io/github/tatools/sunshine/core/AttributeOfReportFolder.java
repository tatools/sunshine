package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
@EqualsAndHashCode
public final class AttributeOfReportFolder implements Attribute {

    private final String key = "reports-path";
    private final Config config;

    public AttributeOfReportFolder(Config config) {
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
