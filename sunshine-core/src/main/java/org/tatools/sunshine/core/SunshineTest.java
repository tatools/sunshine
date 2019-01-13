package org.tatools.sunshine.core;

/**
 * The interface represents a test like a Java class.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface SunshineTest extends Test<Class> {
    @Override
    Class object() throws TestException;

    @Override
    boolean match(Condition condition);

    final class Fake implements SunshineTest {

        private final boolean matchCondition;

        public Fake() {
            this(false);
        }

        public Fake(boolean matchCondition) {
            this.matchCondition = matchCondition;
        }

        @Override
        public Class object() {
            return null;
        }

        @Override
        public boolean match(Condition condition) {
            return matchCondition;
        }
    }
}
