package org.tatools.sunshine.testng;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.tatools.sunshine.core.FileSystemPath;
import org.tatools.sunshine.core.KernelException;
import org.tatools.sunshine.core.SuiteException;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class TestNGKernelTest {

    @Test
    public void status() throws KernelException {
        MatcherAssert.assertThat(
                new TestNGKernel(() -> new FileSystemPath.Fake("src/test/resources/testng.xml"))
                        .status()
                        .code(),
                Matchers.equalTo((short) 0));
    }

    @Test(expected = KernelException.class)
    public void runWithFail() throws KernelException {
        new TestNGKernel(
                        () -> {
                            throw new SuiteException("Fail");
                        })
                .status();
    }

    @Test
    public void with() throws KernelException {
        final Listener l1 = new Listener();
        final Listener l2 = new Listener();
        new TestNGKernel(() -> new FileSystemPath.Fake("src/test/resources/testng.xml"))
                .with(l1)
                .with(l2)
                .status();
        MatcherAssert.assertThat(l1, Matchers.not(Matchers.equalTo(l2)));
    }

    private static final class Listener implements ISuiteListener {
        private int status = 0;

        @Override
        public void onStart(ISuite suite) {
            status++;
        }

        @Override
        public void onFinish(ISuite suite) {
            status++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;

            TestNGKernelTest.Listener listener = (TestNGKernelTest.Listener) o;

            return this.status == listener.status;
        }

        @Override
        public int hashCode() {
            return this.status;
        }
    }
}
