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

    public LoadableTestNGSuite(FileSystem fileSystem, String suitePath, Condition filter) {
        this(fileSystem, new DirectoryBase(suitePath), filter);
    }

    public LoadableTestNGSuite(FileSystem fileSystem, Directory suitePath, Condition filter) {
        this(
                new SunshineSuitePrintable(new SunshineSuiteFilterable(new SunshineSuiteBase(fileSystem), filter)),
                suitePath
        );
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
            FileBase fileBase = new FileBase(suitePath, "sunshine-suite.xml");
            fileBase.write(xmlSuite.toXml());
            return fileBase;
        } catch (TestException | IOException e) {
            throw new SuiteException(e);
        }
    }
}
