package org.sstat.sunshine;

import org.testng.TestNG;

/**
 * The {@link SkipDefaultListeners} class allows to turn off default listeners for TestNG before run a test (tests).
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 20.03.2017
 */
class SkipDefaultListeners implements TestNGConfiguration {
    @Override
    public void applyBeforeRun(TestNG testNG) {
        testNG.setUseDefaultListeners(false);
    }

    @Override
    public void applyAfterRun(TestNG testNG) {

    }
}
