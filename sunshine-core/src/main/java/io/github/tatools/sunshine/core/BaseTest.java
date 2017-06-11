package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
@EqualsAndHashCode
public final class BaseTest implements SunshineTest {
    private final String path;

    public BaseTest(String path) {
        this.path = path;
    }

    @Override
    public Class object() {
        try {
            return Class.forName(toString());
        } catch (ClassNotFoundException e) {
            throw new TestClassException(e);
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
