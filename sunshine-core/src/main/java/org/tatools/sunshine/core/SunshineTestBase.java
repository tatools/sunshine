package org.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 * @deprecated use {@link ClasspathBasedTest} instead of.
 */
@Deprecated
@EqualsAndHashCode
public final class SunshineTestBase implements SunshineTest {
    private final SunshineTest origin;

    public SunshineTestBase(String path) {
        this.origin = new ClasspathBasedTest(path);
    }

    @Override
    public Class object() throws TestException {
        return this.origin.object();
    }

    @Override
    public boolean match(Condition condition) {
        return this.origin.match(condition);
    }

    @Override
    public String toString() {
        return this.origin.toString();
    }
}
