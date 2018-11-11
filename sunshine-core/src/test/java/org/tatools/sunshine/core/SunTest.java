package org.tatools.sunshine.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.tatools.sunshine.core.Status.Fake;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class SunTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shine() {
        exit.expectSystemExitWithStatus(0);
        new Sun(new Kernel.Fake(new Fake())).shine();
    }
}
