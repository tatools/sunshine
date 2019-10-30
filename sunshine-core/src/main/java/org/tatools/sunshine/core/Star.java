package org.tatools.sunshine.core;

/**
 * The {@link Star} interface provides a contract to use {@link Kernel}s. The root idea is that a
 * {@link Star} can shine only it has a {@link Kernel}. And a {@link Kernel} is always a part of a
 * {@link Star}.
 *
 * <p>The interface is a top level abstraction of the Sunshine.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @see Sun
 * @since 0.2
 */
@FunctionalInterface
public interface Star {
    /** Allows this star to shine with an encapsulated {@link Kernel}(s). */
    void shine();
}
