package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 06.04.2017
 */
public class JunitSuite implements Suite<Class<?>[]> {

    private final TestClasses testClasses;

    public JunitSuite(Location location) {
        this(new TestClasses(location));
    }

    public JunitSuite(TestClasses testClasses) {
        this.testClasses = testClasses;
    }

    @Override
    public Class<?>[] tests() {
        return testClasses.classes().stream().map(TestClass::aClass).toArray(size -> new Class[size]);
    }
}
