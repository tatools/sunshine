package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 06.04.2017
 */
public final class JunitSuite implements Suite<Class<?>[]> {

    private final SunshineSuite classesAsSuite;

    public JunitSuite(FileSystem fileSystem, Condition filter) {
        this(new PrintableSuite(new FilterableSuite(new BaseSuite(fileSystem), filter)));
    }

    public JunitSuite(SunshineSuite classesAsSuite) {
        this.classesAsSuite = classesAsSuite;
    }

    @Override
    public Class<?>[] tests() throws SuiteException {
        List<Class<?>> tests = new ArrayList<>();
        for (SunshineTest test : classesAsSuite.tests()) {
            try {
                tests.add(test.object());
            } catch (TestException e) {
                throw new SuiteException(e);
            }
        }
        return tests.toArray(new Class[]{});
    }
}
