package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public final class LoadableTestNGSuite implements TestNGSuite {

    private final SunshineSuite artifacts;
    private final Directory suitePath;

    public LoadableTestNGSuite(Location location, String suitePath, Condition filter) {
        this(location, new RegularDirectory(suitePath), filter);
    }

    public LoadableTestNGSuite(Location location, Directory suitePath, Condition filter) {
        this(new PrintableSuite(new FilterableSuite(new BaseSuite(location), filter)), suitePath);
    }

    public LoadableTestNGSuite(SunshineSuite artifacts, Directory suitePath) {
        this.artifacts = artifacts;
        this.suitePath = suitePath;
    }

    @Override
    public File tests() throws IOException {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Sunshine suite");
        for (SunshineTest sunshineTest : artifacts.tests()) {
            XmlTest test = new TestNGTest(sunshineTest).object();
            test.setSuite(xmlSuite);
            xmlSuite.addTest(test);
        }
        WritableFile writableFile = new WritableFile(suitePath, "sunshine-suite.xml");
        writableFile.write(xmlSuite.toXml());
        return writableFile;
    }
}
