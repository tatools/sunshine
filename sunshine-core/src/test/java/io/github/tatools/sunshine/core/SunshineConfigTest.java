package io.github.tatools.sunshine.core;

import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class SunshineConfigTest {

    @Test
    public void property() {
        new SunshineConfig().property("dad");
    }
}