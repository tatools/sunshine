package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * The class represents a Java class as a test.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
@EqualsAndHashCode
public class TestFromClass implements SunshineTest {
    private final Class origin;

    /**
     * Construct the new instance.
     *
     * @param testClass a class to be treated as a test
     */
    public TestFromClass(Class testClass) {
        this.origin = testClass;
    }

    @Override
    public final Class object() throws TestException {
        return this.origin;
    }

    @Override
    public final boolean match(Condition condition) {
        return condition.applicable(this.toString());
    }

    @Override
    public final String toString() {
        return this.origin.getName();
    }
}
