package io.github.tatools.sunshine.core;

import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class SunshineSuitePrintable implements SunshineSuite {

    private final SunshineSuite sunshineSuite;

    public SunshineSuitePrintable(SunshineSuite sunshineSuite) {
        this.sunshineSuite = sunshineSuite;
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        final List<SunshineTest> tests = this.sunshineSuite.tests();
        final StringBuilder message = new StringBuilder();
        message.append("Sunshine found ")
                .append(tests.size())
                .append(" classes by the specified pattern. They all will be passed to appropriate xUnit engine.")
                .append("\nClasses:");
        tests.forEach(c -> message.append("\n- ").append(c));
        System.out.println(message);
        return tests;
    }
}
