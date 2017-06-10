package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 10.06.2017
 */
public interface SunshineTest extends Test<Class> {
    @Override
    Class object();

    @Override
    boolean match(Rule rule);
}
