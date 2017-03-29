package io.github.tatools.sunshine;

import org.testng.TestNG;

/**
 * The {@link TestNGCompositeConfiguration} class allows to package several {@link TestNGConfiguration}s and
 * represents them as an instance of {@link TestNGConfiguration}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 29.03.2017
 */
public final class TestNGCompositeConfiguration implements TestNGConfiguration {

    private final TestNGConfiguration[] configurations;

    public TestNGCompositeConfiguration(TestNGConfiguration... configurations) {
        this.configurations = configurations;
    }


    @Override
    public void apply(TestNG testNG) {
        for (TestNGConfiguration configuration : configurations) {
            configuration.apply(testNG);
        }
    }
}
