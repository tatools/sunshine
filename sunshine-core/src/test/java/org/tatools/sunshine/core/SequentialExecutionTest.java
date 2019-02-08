package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class SequentialExecutionTest {

    @Test
    public void testStatus() throws KernelException {
        MatcherAssert.assertThat(
                new SequentialExecution<Object>(
                        new Kernel.Fake(new Status.Fake()),
                        new Kernel.Fake(new Status.Fake((short) 1, 2, 1, 1))
                ).status().code(),
                Matchers.is((short) 1)
        );
    }

    @Test
    public void testWithListeners() {
        final List<Object> listeners = new ArrayList<>();
        new SequentialExecution<Object>(new Kernel.Fake(new Status.Fake(), listeners)).with(new Object());
        MatcherAssert.assertThat(listeners, Matchers.hasSize(1));
    }
}
