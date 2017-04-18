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
     * @todo #26 Remove this interface as now we can pass listeners to an engine.
     */
    void apply(TestNG testNG);


    class Empty implements TestNGConfiguration {

        @Override
        public void apply(TestNG testNG) {

        }
    }
}
