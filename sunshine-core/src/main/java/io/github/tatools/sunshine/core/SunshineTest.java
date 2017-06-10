package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 10.06.2017
 */
public interface SunshineTest extends Test<Class> {
    @Override
    Class object();

    @Override
    boolean match(Rule rule);

    final class Fake implements SunshineTest {

        private final boolean matchRule;

        public Fake() {
            this(false);
        }

        public Fake(boolean matchRule) {
            this.matchRule = matchRule;
        }

        @Override
        public Class object() {
            return null;
        }

        @Override
        public boolean match(Rule rule) {
            return matchRule;
        }
    }
}
