package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
public interface Rule {
    boolean pass(String identity);

    class Fake implements Rule {
        private final boolean answer;

        public Fake(boolean answer) {
            this.answer = answer;
        }

        @Override
        public boolean pass(String identity) {
            return answer;
        }
    }
}
