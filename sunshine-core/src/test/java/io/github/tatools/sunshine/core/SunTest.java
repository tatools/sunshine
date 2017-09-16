package io.github.tatools.sunshine.core;

import io.github.tatools.sunshine.core.Status.Fake;
import org.junit.Test;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class SunTest {
    @Test
    public void shine() {
        new Sun(new Kernel.Fake(new Fake())).shine();
    }
}
