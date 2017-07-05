package io.github.tatools.sunshine.core;

import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class ConfigFromSunshineTest {

    @Test
    public void property() {
        new ConfigFromSunshine().attribute("dad");
    }
}