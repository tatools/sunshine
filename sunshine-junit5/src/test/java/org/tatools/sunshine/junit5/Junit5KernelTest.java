package org.tatools.sunshine.junit5;

import java.util.ArrayList;
import lombok.EqualsAndHashCode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.tatools.sunshine.core.KernelException;

/**
 * @author Dmytro Serdiuk
 * @version $Id$
 */
public class Junit5KernelTest {

    @Test
    public void run() throws KernelException {
        MatcherAssert.assertThat(
                new Junit5Kernel(ArrayList::new).status().code(), Matchers.equalTo((short) 0));
    }

    @Test
    public void with() throws KernelException {
        final Listener l1 = new Listener();
        final Listener l2 = new Listener();
        new Junit5Kernel(ArrayList::new).with(l1).with(l2).status();
        MatcherAssert.assertThat(l1, Matchers.not(Matchers.equalTo(l2)));
    }

    @EqualsAndHashCode
    private final class Listener implements TestExecutionListener {
        private int call = 0;

        @Override
        public void executionFinished(
                TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
            this.call = 1;
        }
    }
}
