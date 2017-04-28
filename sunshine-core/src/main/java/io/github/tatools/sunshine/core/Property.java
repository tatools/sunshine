package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public interface Property<D> {
    /*
    @todo #57:30m Review all implementations:
     - make them final
     - make TurnProperty as part of interface
     - create unit tests
     */

    D value();
    boolean present();
}
