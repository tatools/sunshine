package io.github.tatools.sunshine;

import org.testng.TestNG;

/**
 * The {@link TestNGConfiguration} interface allows to apply some configurations to TestNG runner
 * before and after tests execution.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @see TestNGConfigurationException
 * @since 17.03.2017
 */
public interface TestNGConfiguration {

    void applyBeforeRun(TestNG testNG);

    void applyAfterRun(TestNG testNG);

}
