package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;

/**
 * The {@link LoadableTestNGSuite} class represents a TestNG suite prepared from the Java classes. The suite has to
 * be saved as a TestNG XML file.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@SuppressWarnings("WeakerAccess")
public final class LoadableTestNGSuite implements TestNGSuite {

    private static final String SUITE_NAME = "Sunshine suite";
    private static final String SUITE_XML_FILE_NAME = "sunshine-suite.xml";
    private final SunshineSuite artifacts;
    private final File suiteXml;

    /**
     * Construct the new instance with the specified tests filter. All tests will be loaded from the classpath.
     *
     * @param filter the filter to be used to select desired tests
     * @see #LoadableTestNGSuite(FileSystem, Condition)
     * @since 0.2
     */
    public LoadableTestNGSuite(Condition filter) {
        this(new FileSystemOfClasspathClasses(), filter);
    }

    /**
     * Constructs new instance with the specified file system and tests filter. All filtered tests
     * will be printed to {@link System#out}.
     * <p>The TestNG XML file will be saved to the default temporary folder.</p>
     *
     * @param fileSystem the place with the tests
     * @param filter     the filter to be used to select desired tests
     * @since 0.2
     */
    public LoadableTestNGSuite(FileSystem fileSystem, Condition filter) {
        this(new SunshineSuitePrintable(new SunshineSuiteFilterable(new SunshineSuiteBase(fileSystem), filter)));
    }

    /**
     * Constructs new instance with the specified suite.
     * <p>The TestNG XML file will be saved to the temporary directory named "./sunshine-generated-suites".</p>
     *
     * @param suite the tests to be used
     * @since 0.2
     */
    public LoadableTestNGSuite(SunshineSuite suite) {
        this(
                suite,
                new DirectoryWithAutomaticCreation(
                        new DirectoryWithAutomaticDeletion(
                                new DirectorySafe("./sunshine-generated-suites")
                        )
                )
        );
    }

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

    /**
     * Constructs new instance with the specified file system, suite's directory and tests filter. All filtered tests
     * will be printed to {@link System#out}.
     *
     * @param fileSystem        the place with the tests
     * @param xmlSuiteDirectory the place to store suite file
     * @param filter            the filter to be used to select desired tests
     * @since 0.1
     */
    public LoadableTestNGSuite(FileSystem fileSystem, Directory xmlSuiteDirectory, Condition filter) {
        this(
                new SunshineSuitePrintable(new SunshineSuiteFilterable(new SunshineSuiteBase(fileSystem), filter)),
                xmlSuiteDirectory
        );
    }

    /**
     * Constructs new instance with the specified suite and suite's directory.
     *
     * @param suite             the tests to be used
     * @param xmlSuiteDirectory the directory to store suite file
     * @since 0.1
     */
    public LoadableTestNGSuite(SunshineSuite suite, Directory xmlSuiteDirectory) {
        this.artifacts = suite;
        this.suiteXml = new FileBase(xmlSuiteDirectory, SUITE_XML_FILE_NAME);
    }

    @Override
    public File tests() throws SuiteException {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName(SUITE_NAME);
        try {
            for (SunshineTest sunshineTest : this.artifacts.tests()) {
                XmlTest test = new TestNGTest(sunshineTest).object();
                test.setSuite(xmlSuite);
                xmlSuite.addTest(test);
            }
            this.suiteXml.write(xmlSuite.toXml());
            return this.suiteXml;
        } catch (TestException | IOException e) {
            throw new SuiteException(e);
        }
    }
}
