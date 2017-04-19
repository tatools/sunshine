package io.github.tatools.sunshine;

import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public final class LoadableTestNGSuite implements TestNGSuite {

    private final TestClasses artifacts;
    private final Directory suitePath;

    public LoadableTestNGSuite(Location location, String suitePath) {
        this(new TestClasses(location), new RegularDirectory(suitePath));
    }

    public LoadableTestNGSuite(Location location, Directory suitePath) {
        this(new TestClasses(location), suitePath);
    }

    public LoadableTestNGSuite(TestClasses artifacts, Directory suitePath) {
        this.artifacts = artifacts;
        this.suitePath = suitePath;
    }

    @Override
    public File tests() {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Sunshine suite");
        for (TestClass testClass : artifacts.classes()) {
            XmlTest test = new TestNGTest(testClass).object();
            test.setSuite(xmlSuite);
            xmlSuite.addTest(test);
        }
        suitePath.create();
        WritableFile writableFile = new WritableFile(suitePath, "sunshine-suite.xml");
        writableFile.write(xmlSuite.toXml());
        return writableFile;
    }
}
