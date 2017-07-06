package io.github.tatools.sunshine.core;

import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConfigFromSunshineTest {

    @Test
    public void property() {
        new ConfigFromSunshine().attribute("dad");
    }
}