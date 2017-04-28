package io.github.tatools.sunshine;

import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class TestNGTestTest {

    @Test(expected = TestClassException.class)
    public void asClassWithGhostClass() {
        new TestNGTest("io/github/tatools/testng/Test11.class").object();
    }

    @Test
    public void withRealClass() {
        new TestNGTest("io/github/tatools/sunshine/Engine.class").object();
    }
}