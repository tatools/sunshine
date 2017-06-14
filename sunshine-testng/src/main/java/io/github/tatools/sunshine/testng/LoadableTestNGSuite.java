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

    public LoadableTestNGSuite(Filesystem filesystem, String suitePath, Condition filter) {
        this(filesystem, new RegularDirectory(suitePath), filter);
    }

    public LoadableTestNGSuite(Filesystem filesystem, Directory suitePath, Condition filter) {
        this(new PrintableSuite(new FilterableSuite(new BaseSuite(filesystem), filter)), suitePath);
    }

    public LoadableTestNGSuite(SunshineSuite artifacts, Directory suitePath) {
        this.artifacts = artifacts;
        this.suitePath = suitePath;
    }

    @Override
    public File tests() throws SuiteException {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Sunshine suite");
        try {
            for (SunshineTest sunshineTest : artifacts.tests()) {
                XmlTest test = new TestNGTest(sunshineTest).object();
                test.setSuite(xmlSuite);
                xmlSuite.addTest(test);
            }
            WritableFile writableFile = new WritableFile(suitePath, "sunshine-suite.xml");
            writableFile.write(xmlSuite.toXml());
            return writableFile;
        } catch (TestException | IOException e) {
            throw new SuiteException(e);
        }
    }
}
