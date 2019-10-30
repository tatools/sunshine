package org.tatools.sunshine.testng;

import org.junit.Test;
import org.tatools.sunshine.core.TestException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TestNGTestTest {

    @Test(expected = TestException.class)
    public void asClassWithGhostClass() throws TestException {
        new TestNGTest("org/tatools/testng/Test11.class").object();
    }

    @Test
    public void withRealClass() throws TestException {
        new TestNGTest("org/tatools/sunshine/core/Test.class").object();
    }
}
