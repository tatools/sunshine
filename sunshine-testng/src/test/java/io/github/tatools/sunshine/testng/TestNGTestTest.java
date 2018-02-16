package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.TestException;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TestNGTestTest {

    @Test(expected = TestException.class)
    public void asClassWithGhostClass() throws TestException {
        new TestNGTest("io/github/tatools/testng/Test11.class").object();
    }

    @Test
    public void withRealClass() throws TestException {
        new TestNGTest("io/github/tatools/sunshine/core/Test.class").object();
    }
}