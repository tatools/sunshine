package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
@EqualsAndHashCode
public class TurnProperty<D> implements Property<D> {

    private final Property<D> first;
    private final Property<D> second;

    public TurnProperty(Property<D> first, Property<D> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public D value() {
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
