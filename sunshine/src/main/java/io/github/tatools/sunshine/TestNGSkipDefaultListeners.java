package io.github.tatools.sunshine;

import org.testng.TestNG;

/**
 * The {@link TestNGSkipDefaultListeners} class allows to turn off default listeners for
 * TestNG before run a test (tests).
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 20.03.2017
 */
public final class TestNGSkipDefaultListeners implements TestNGConfiguration {
    @Override
    public void apply(TestNG testNG) {
        testNG.setUseDefaultListeners(false);
    }
}
