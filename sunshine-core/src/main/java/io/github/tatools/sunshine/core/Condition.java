package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@FunctionalInterface
public interface Condition {
    /**
     * Allows verifying this condition on an identity. The identity is the full name of a class like
     * "io.github.my.FirstTest".
     *
     * @param identity a full name of a class
     * @return true if the rule passes otherwise false
     */
    boolean applicable(String identity);

    class Fake implements Condition {
        private final boolean answer;

        public Fake(boolean answer) {
            this.answer = answer;
        }

        @Override
        public boolean applicable(String identity) {
            return answer;
        }
    }
}
