package com.softserveinc.sstat.sunshine;

import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class TestNGTestTest {

    @Test(expected = TestClassException.class)
    public void asClassWithGhostClass() {
        new TestNGTest("com/softserveinc/sstat/testng/Test11.class").object();
    }

    @Test
    public void withRealClass() {
        new TestNGTest("com/softserveinc/sstat/sunshine/Engine.class").object();
    }
}