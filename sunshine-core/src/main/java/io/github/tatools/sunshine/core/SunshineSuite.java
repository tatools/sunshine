package io.github.tatools.sunshine.core;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 10.06.2017
 */
public interface SunshineSuite extends Suite<List<SunshineTest>> {
    @Override
    List<SunshineTest> tests() throws SuiteException;

    final class Fake implements SunshineSuite {
        private final List<SunshineTest> tests;

        public Fake(SunshineTest... tests) {
            this.tests = Arrays.asList(tests);
        }

        @Override
        public List<SunshineTest> tests() {
            return tests;
        }
    }
}
