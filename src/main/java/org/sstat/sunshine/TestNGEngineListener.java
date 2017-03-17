package org.sstat.sunshine;

import org.testng.TestNG;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public interface TestNGEngineListener {

    void beforeRun(TestNG testNG);

    void afterRun(TestNG testNG);

}
