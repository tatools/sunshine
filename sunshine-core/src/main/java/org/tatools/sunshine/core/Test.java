package org.tatools.sunshine.core;

/**
 * The interface represents a test like an generic object.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Test<T> {
    T object() throws TestException;

    boolean match(Condition condition);

    class Fake<D> implements Test<D> {
        private final D d;
        private final boolean ruleAnswer;

        public Fake(D d, boolean ruleAnswer) {
            this.d = d;
            this.ruleAnswer = ruleAnswer;
        }

        @Override
        public D object() {
            return d;
        }

        @Override
        public boolean match(Condition condition) {
            return ruleAnswer;
        }
    }
}
