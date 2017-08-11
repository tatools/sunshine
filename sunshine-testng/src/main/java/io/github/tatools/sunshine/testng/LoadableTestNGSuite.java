package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@SuppressWarnings("WeakerAccess")
public final class LoadableTestNGSuite implements TestNGSuite {

    private final SunshineSuite artifacts;
    private final Directory suitePath;

    /**
     * Construct new instance with the specified file system, suite's directory and tests filter.
     * If suite's directory ({@code xmlSuiteDirectory}) doesn't exist, it will be created automatically.
     *
     * @param fileSystem        the place with the tests
     * @param xmlSuiteDirectory the place to store suite file
     * @param filter            the filter to be used to select desired tests
     * @see #LoadableTestNGSuite(FileSystem, Directory, Condition)
     * @since 0.2
     */
    public LoadableTestNGSuite(FileSystem fileSystem, String xmlSuiteDirectory, Condition filter) {
        this(
                fileSystem,
                new DirectoryWithAutomaticCreation(new DirectorySafe(new DirectoryBase(xmlSuiteDirectory))),
                filter
        );
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
            for (SunshineTest sunshineTest : this.artifacts.tests()) {
                XmlTest test = new TestNGTest(sunshineTest).object();
                test.setSuite(xmlSuite);
                xmlSuite.addTest(test);
            }
            FileBase fileBase = new FileBase(this.suitePath, "sunshine-suite.xml");
            fileBase.write(xmlSuite.toXml());
            return fileBase;
        } catch (TestException | IOException e) {
            throw new SuiteException(e);
        }
    }
}
