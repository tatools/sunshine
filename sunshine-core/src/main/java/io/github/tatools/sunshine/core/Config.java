package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public interface Config {
    //  @todo #30 Consider to move logic of properties loading to separate project.

    String property(String key);
    boolean has(String key);
}
