package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
@EqualsAndHashCode
public final class SunshineTestBase implements SunshineTest {
    private final String path;

    public SunshineTestBase(String path) {
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
