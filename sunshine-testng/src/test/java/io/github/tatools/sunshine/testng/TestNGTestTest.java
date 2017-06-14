package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.TestException;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class TestNGTestTest {

    @Test(expected = TestException.class)
    public void asClassWithGhostClass() throws TestException {
        new TestNGTest("io/github/tatools/testng/Test11.class").object();
    }

    @Test
    public void withRealClass() throws TestException {
        new TestNGTest("io/github/tatools/sunshine/core/Engine.class").object();
    }
}