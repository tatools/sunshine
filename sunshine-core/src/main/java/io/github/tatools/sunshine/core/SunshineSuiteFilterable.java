package io.github.tatools.sunshine.core;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class SunshineSuiteFilterable implements SunshineSuite {

    private final SunshineSuite suite;
    private final Condition filter;

    public SunshineSuiteFilterable(SunshineSuite suite, Condition filter) {
        this.suite = suite;
        this.filter = filter;
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        return suite.tests().stream().filter(classTest -> classTest.match(filter)).collect(Collectors.toList());
    }
}
