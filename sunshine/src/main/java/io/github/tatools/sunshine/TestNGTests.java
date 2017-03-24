package io.github.tatools.sunshine;

import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
final class TestNGTests implements Tests {
    private final TestClasses artifacts;

    TestNGTests(Location location) {
        this(new TestClasses(location));
    }

    TestNGTests(TestClasses artifacts) {
        this.artifacts = artifacts;
    }

    @Override
    public XmlSuite suite() {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Sunshine default tests suit");
        for (TestClass testClass : artifacts.classes()) {
            XmlTest test = new TestNGTest(testClass).object();
            test.setSuite(xmlSuite);
            xmlSuite.addTest(test);
        }
        return xmlSuite;
    }
}
