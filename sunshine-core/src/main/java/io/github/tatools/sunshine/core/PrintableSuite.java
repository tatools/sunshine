package io.github.tatools.sunshine.core;

import java.io.IOException;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 10.06.2017
 */
public final class PrintableSuite implements SunshineSuite {

    private final SunshineSuite sunshineSuite;

    public PrintableSuite(SunshineSuite sunshineSuite) {
        this.sunshineSuite = sunshineSuite;
    }

    @Override
    public List<SunshineTest> tests() throws IOException {
        System.out.println("Sunshine suite contains the following tests:");
        this.sunshineSuite.tests().forEach(System.out::println);
        return this.sunshineSuite.tests();
    }
}
