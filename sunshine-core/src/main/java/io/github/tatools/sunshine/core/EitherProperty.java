package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
@EqualsAndHashCode
public final class EitherProperty implements Property {

    private final Property first;
    private final Property second;

    public EitherProperty(Property first, Property second) {
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
