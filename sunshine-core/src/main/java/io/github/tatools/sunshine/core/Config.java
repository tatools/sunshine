package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @todo #30 Consider to move logic of properties loading to separate project.
 * @since 21.04.2017
 */
public interface Config {
    String property(String key);

    boolean has(String key);
}
