package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
@EqualsAndHashCode
public final class AttributeFromSequence implements Attribute {

    private final Attribute first;
    private final Attribute second;

    public AttributeFromSequence(Attribute first, Attribute second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String value() {
        if (first.present()) {
            return first.value();
        }
        return second.value();
    }

    @Override
    public boolean present() {
        return first.present() || second.present();
    }
}
