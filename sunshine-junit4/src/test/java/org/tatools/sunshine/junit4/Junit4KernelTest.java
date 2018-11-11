package org.tatools.sunshine.junit4;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.tatools.sunshine.core.KernelException;
import org.tatools.sunshine.core.SuiteException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class Junit4KernelTest {

    @Test
    public void run() throws KernelException {
        MatcherAssert.assertThat(
                new Junit4Kernel(() -> new Class[]{}).status().code(),
                Matchers.equalTo((short) 0)
        );
    }

    @Test(expected = KernelException.class)
    public void runWithFail() throws KernelException {
        new Junit4Kernel(() -> {
            throw new SuiteException("Fail");
        }).status();
    }

    @Test
    public void with() throws KernelException {
        final Listener l1 = new Listener();
        final Listener l2 = new Listener();
        new Junit4Kernel(() -> new Class[]{}).with(l1).with(l2).status();
        MatcherAssert.assertThat(l1, Matchers.not(Matchers.equalTo(l2)));
    }

    private static final class Listener extends RunListener {
        private int status = 0;

        @Override
        public void testRunStarted(Description description) {
            status++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Junit4KernelTest.Listener listener = (Junit4KernelTest.Listener) o;

            return this.status == listener.status;
        }

        @Override
        public int hashCode() {
            return this.status;
        }
    }
}
