package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 06.04.2017
 */
public class JunitTests implements Tests<Class<?>[]> {

    private final TestClasses testClasses;

    public JunitTests(Location location) {
        this(new TestClasses(location));
    }

    public JunitTests(TestClasses testClasses) {
        this.testClasses = testClasses;
    }

    @Override
    public Class<?>[] suite() {
        return testClasses.classes().stream().map(TestClass::aClass).toArray(size -> new Class[size]);
    }
}
