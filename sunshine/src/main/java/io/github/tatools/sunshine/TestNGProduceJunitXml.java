package io.github.tatools.sunshine;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.reporters.JUnitXMLReporter;

/**
 * The {@link TestNGProduceJunitXml} class allows to tell TestNG to create JUNIT xml files for tests run.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 29.03.2017
 */
public final class TestNGProduceJunitXml implements TestNGConfiguration {
    @Override
    public void apply(TestNG testNG) {
        ITestNGListener jUnitXMLReporter = new JUnitXMLReporter();
        testNG.addListener(jUnitXMLReporter);
    }
}
