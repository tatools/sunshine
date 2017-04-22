package io.github.tatools.sunshine;

import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public final class LoadableTestNGSuite implements TestNGSuite {

    private final Suite<List<Test<Class>>> artifacts;
    private final Directory suitePath;

    public LoadableTestNGSuite(Location location, String suitePath, Rule filter) {
        this(new FilteredSuite(new ClassesAsSuite(location), filter), new RegularDirectory(suitePath));
    }

    public LoadableTestNGSuite(Location location, Directory suitePath, Rule filter) {
        this(new FilteredSuite(new ClassesAsSuite(location), filter), suitePath);
    }

    public LoadableTestNGSuite(Suite<List<Test<Class>>> artifacts, Directory suitePath) {
        this.artifacts = artifacts;
        this.suitePath = suitePath;
    }

    @Override
    public File tests() {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Sunshine suite");
        for (Test<Class> classAsTest : artifacts.tests()) {
            XmlTest test = new TestNGTest(classAsTest).object();
            test.setSuite(xmlSuite);
            xmlSuite.addTest(test);
        }
        suitePath.create();
        WritableFile writableFile = new WritableFile(suitePath, "sunshine-suite.xml");
        writableFile.write(xmlSuite.toXml());
        return writableFile;
    }
}
