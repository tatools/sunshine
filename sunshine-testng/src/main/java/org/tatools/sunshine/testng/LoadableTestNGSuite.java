package org.tatools.sunshine.testng;

import org.tatools.sunshine.core.*;
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

    private static final String SUNSHINE_SUITE = "Sunshine suite";
    private final String name;
    private final SunshineSuite artifacts;
    private final File suiteXml;

    /**
     * Construct the new instance. The {@value #SUNSHINE_SUITE} is used as a name of the suite via wrapping of
     * {@link #LoadableTestNGSuite(String, Condition)}.
     *
     * @param filter the filter to be used to select desired tests
     * @see #LoadableTestNGSuite(String, Condition)
     */
    public LoadableTestNGSuite(Condition filter) {
        this(SUNSHINE_SUITE, filter);
    }

    /**
     * Construct the new instance. All tests will be loaded from the classpath.
     *
     * @param suiteName the name of the suite
     * @param filter    the filter to be used to select desired tests
     */
    public LoadableTestNGSuite(String suiteName, Condition filter) {
        this(suiteName, new FileSystemOfClasspathClasses(), filter);
    }

    /**
     * Construct the new instance. The {@value #SUNSHINE_SUITE} is used as a name of the suite via wrapping of
     * {@link #LoadableTestNGSuite(String, FileSystem, Condition)}.
     *
     * @param fileSystem the place with the tests
     * @param filter     the filter to be used to select desired tests
     * @see #LoadableTestNGSuite(String, FileSystem, Condition)
     */
    public LoadableTestNGSuite(FileSystem fileSystem, Condition filter) {
        this(SUNSHINE_SUITE, fileSystem, filter);
    }

    /**
     * Construct the new instance. All filtered tests will be printed to {@link System#out}.
     * <p>The TestNG XML file will be saved to the default temporary folder.</p>
     *
     * @param suiteName  the name of the suite
     * @param fileSystem the place with the tests
     * @param filter     the filter to be used to select desired tests
     */
    public LoadableTestNGSuite(String suiteName, FileSystem fileSystem, Condition filter) {
        this(suiteName, new SunshineSuitePrintable(new SunshineSuiteFilterable(new SunshineSuiteBase(fileSystem), filter)));
    }

    /**
     * Construct the new instance. The {@value #SUNSHINE_SUITE} is used as a name of the suite via wrapping of
     * {@link #LoadableTestNGSuite(String, SunshineSuite)}.
     *
     * @param suite the tests to be used
     * @see #LoadableTestNGSuite(String, SunshineSuite)
     */
    public LoadableTestNGSuite(SunshineSuite suite) {
        this(SUNSHINE_SUITE, suite);
    }

    /**
     * Construct the new instance.
     * <p>The TestNG XML file will be saved to the temporary directory named "./sunshine-generated-suites".</p>
     *
     * @param suiteName the name of the suite
     * @param suite     the tests to be used
     */
    public LoadableTestNGSuite(String suiteName, SunshineSuite suite) {
        this(suiteName,
                suite,
                new DirectoryWithAutomaticCreation(
                        new DirectoryWithAutomaticDeletion(
                                new DirectorySafe("./sunshine-generated-suites")
                        )
                )
        );
    }

    /**
     * Construct the new instance. The {@value #SUNSHINE_SUITE} is used as a name of the suite via wrapping of
     * {@link #LoadableTestNGSuite(String, FileSystem, String, Condition)}.
     *
     * @param fileSystem        the place with the tests
     * @param xmlSuiteDirectory the place to store suite file
     * @param filter            the filter to be used to select desired tests
     * @see #LoadableTestNGSuite(String, FileSystem, String, Condition)
     */
    public LoadableTestNGSuite(FileSystem fileSystem, String xmlSuiteDirectory, Condition filter) {
        this(SUNSHINE_SUITE, fileSystem, xmlSuiteDirectory, filter);
    }

    /**
     * Construct the new instance. If suite's directory ({@code xmlSuiteDirectory}) doesn't exist, it will be created
     * automatically.
     *
     * @param suiteName         the name of the suite
     * @param fileSystem        the place with the tests
     * @param xmlSuiteDirectory the place to store suite file
     * @param filter            the filter to be used to select desired tests
     */
    public LoadableTestNGSuite(String suiteName, FileSystem fileSystem, String xmlSuiteDirectory, Condition filter) {
        this(suiteName,
                fileSystem,
                new DirectoryWithAutomaticCreation(new DirectorySafe(new DirectoryBase(xmlSuiteDirectory))),
                filter
        );
    }


    /**
     * Construct the new instance. The {@value #SUNSHINE_SUITE} is used as a name of the suite via wrapping of
     * {@link #LoadableTestNGSuite(String, FileSystem, Directory, Condition)}.
     *
     * @param fileSystem        the place with the tests
     * @param xmlSuiteDirectory the place to store suite file
     * @param filter            the filter to be used to select desired tests
     * @see #LoadableTestNGSuite(String, FileSystem, Directory, Condition)
     */
    public LoadableTestNGSuite(FileSystem fileSystem, Directory xmlSuiteDirectory, Condition filter) {
        this(SUNSHINE_SUITE, fileSystem, xmlSuiteDirectory, filter);
    }

    /**
     * Construct the new instance. All filtered tests will be printed to {@link System#out}.
     *
     * @param suiteName         the name of the suite
     * @param fileSystem        the place with the tests
     * @param xmlSuiteDirectory the place to store suite file
     * @param filter            the filter to be used to select desired tests
     */
    public LoadableTestNGSuite(String suiteName, FileSystem fileSystem, Directory xmlSuiteDirectory, Condition filter) {
        this(suiteName,
                new SunshineSuitePrintable(new SunshineSuiteFilterable(new SunshineSuiteBase(fileSystem), filter)),
                xmlSuiteDirectory
        );
    }

    /**
     * Construct the new instance. The {@value #SUNSHINE_SUITE} is used as a name of the suite via wrapping of
     * {@link #LoadableTestNGSuite(String, SunshineSuite, Directory)}.
     *
     * @param suite             the tests to be used
     * @param xmlSuiteDirectory the directory to store suite file
     * @see #LoadableTestNGSuite(String, SunshineSuite, Directory)
     */
    public LoadableTestNGSuite(SunshineSuite suite, Directory xmlSuiteDirectory) {
        this(SUNSHINE_SUITE, suite, xmlSuiteDirectory);
    }

    /**
     * Construct the new instance. "sunshine-suite.xml" is used as a name for XML suite file.
     *
     * @param suiteName         the name of the suite
     * @param suite             the tests to be used
     * @param xmlSuiteDirectory the directory to store suite file
     */
    public LoadableTestNGSuite(String suiteName, SunshineSuite suite, Directory xmlSuiteDirectory) {
        this(suiteName, suite, new FileBase(xmlSuiteDirectory, "sunshine-suite.xml"));
    }

    /**
     * Construct the new instance.
     *
     * @param suiteName   the name of the suite
     * @param suite       the suite
     * @param xmlFileName the name of TestNG XML file
     */
    public LoadableTestNGSuite(String suiteName, SunshineSuite suite, File xmlFileName) {
        this.name = suiteName;
        this.artifacts = suite;
        this.suiteXml = xmlFileName;
    }

    @Override
    public File tests() throws SuiteException {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName(this.name);
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
