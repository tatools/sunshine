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
        System.out.println("Sunshine suite contains the following tests:");
        this.sunshineSuite.tests().forEach(System.out::println);
        return this.sunshineSuite.tests();
    }
}
