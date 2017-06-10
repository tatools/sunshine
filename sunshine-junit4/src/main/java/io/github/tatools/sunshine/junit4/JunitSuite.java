package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.*;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 06.04.2017
 */
public class JunitSuite implements Suite<Class<?>[]> {

    private final SunshineSuite classesAsSuite;

    public JunitSuite(Location location, Rule filter) {
        this(new PrintableSuite(new FilterableSuite(new BaseSuite(location), filter)));
    }

    public JunitSuite(SunshineSuite classesAsSuite) {
        this.classesAsSuite = classesAsSuite;
    }

    @Override
    public Class<?>[] tests() {
        return classesAsSuite.tests().stream().map(Test::object).toArray(size -> new Class[size]);
    }
}
