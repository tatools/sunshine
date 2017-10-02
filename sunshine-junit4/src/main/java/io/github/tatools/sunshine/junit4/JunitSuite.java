package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link JunitSuite} class represents a JUnit 4 suite prepared from the Java classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class JunitSuite implements Suite<Class<?>[]> {

    private final SunshineSuite suite;

    /**
     * Construct the new instance with the specified tests filter. All tests will be loaded from the classpath.
     *
     * @param filter the filter to be used to select desired tests
     * @see #JunitSuite(FileSystem, Condition)
     * @since 0.2
     */
    public JunitSuite(Condition filter) {
        this(new FileSystemOfClasspathClasses(), filter);
    }

    /**
     * Construct the new instance with the specified file system and tests filter. All filtered tests
     * will be printed to {@link System#out}.
     *
     * @param fileSystem the place with the tests
     * @param filter     the filter to be used to select desired tests
     * @since 0.1
     */
    public JunitSuite(FileSystem fileSystem, Condition filter) {
        this(new SunshineSuitePrintable(new SunshineSuiteFilterable(new SunshineSuiteBase(fileSystem), filter)));
    }

    /**
     * Construct the new instance with the specified suite.
     *
     * @param classesAsSuite the suite with the tests
     * @since 0.1
     */
    public JunitSuite(SunshineSuite classesAsSuite) {
        this.suite = classesAsSuite;
    }

    @Override
    public Class<?>[] tests() throws SuiteException {
        List<Class<?>> tests = new ArrayList<>();
        for (SunshineTest test : this.suite.tests()) {
            try {
                tests.add(test.object());
            } catch (TestException e) {
                throw new SuiteException(e);
            }
        }
        return tests.toArray(new Class[]{});
    }
}
