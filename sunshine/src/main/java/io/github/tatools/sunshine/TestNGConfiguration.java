package io.github.tatools.sunshine;

import org.testng.TestNG;

/**
 * The {@link TestNGConfiguration} interface allows to apply some configurations to TestNG runner
 * before tests execution.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @see TestNGConfigurationException
 * @since 17.03.2017
 */
public interface TestNGConfiguration {

    /**
     * Apply some modifications to an instance of {@link TestNG} before tests tun.
     *
     * @param testNG an instance to be configured
     *
     * @todo #23:1h It's a bad idea to allow to modify TestNG instance.
     *  Need to consider another way to allow set up listeners.
     */
    void apply(TestNG testNG);
}
