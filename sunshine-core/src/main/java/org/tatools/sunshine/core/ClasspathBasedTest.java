package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * The class represents a classpath file as a test in form of Java class.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
@EqualsAndHashCode
public final class ClasspathBasedTest implements SunshineTest {
    private final String path;

    /**
     * Construct the new instance.
     *
     * @param path is a relative path in a file system which includes class name (like {@code org/my/tests/Test1}).
     *             It has to be relative to current classpath. It can have {@code .class} extension or not.
     */
    public ClasspathBasedTest(String path) {
        this.path = path;
    }

    @Override
    public Class object() throws TestException {
        try {
            return Class.forName(toString());
        } catch (ClassNotFoundException e) {
            throw new TestException(e);
        }
    }

    @Override
    public boolean match(Condition condition) {
        return condition.applicable(this.toString());
    }

    @Override
    public String toString() {
        return path.replaceAll("[/\\\\]", ".").replaceFirst("^\\.", "").replace(".class", "");
    }
}
