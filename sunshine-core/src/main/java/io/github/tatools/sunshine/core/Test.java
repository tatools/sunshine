package io.github.tatools.sunshine.core;

/**
 * The interface represents a class with a test (tests).
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public interface Test<T> {
    T object();

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
