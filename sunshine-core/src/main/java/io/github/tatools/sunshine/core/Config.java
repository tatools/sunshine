package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Config {
    String attribute(String key);

    boolean has(String key);
}
