package org.tatools.sunshine.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The suite allows creation a test suite based on predefined classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public final class SuiteFromClasses implements SunshineSuite {
    private final Class[] classes;

    /**
     * Construct new instance.
     *
     * @param clazz a class object (like {@code MyTest1.class})
     */
    public SuiteFromClasses(Class... clazz) {
        this.classes = clazz;
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        return Arrays.stream(this.classes).map(TestFromClass::new).collect(Collectors.toList());
    }
}
