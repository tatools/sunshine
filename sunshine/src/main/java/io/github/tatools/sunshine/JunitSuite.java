package io.github.tatools.sunshine;

import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 06.04.2017
 */
public class JunitSuite implements Suite<Class<?>[]> {

    private final Suite<List<Test<Class>>> classesAsSuite;

    public JunitSuite(Location location, Rule filter) {
        this(new FilteredSuite(new ClassesAsSuite(location), filter));
    }

    public JunitSuite(Suite<List<Test<Class>>> classesAsSuite) {
        this.classesAsSuite = classesAsSuite;
    }

    @Override
    public Class<?>[] tests() {
        return classesAsSuite.tests().stream().map(Test::object).toArray(size -> new Class[size]);
    }
}
