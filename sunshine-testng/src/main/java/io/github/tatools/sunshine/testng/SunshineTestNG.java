package io.github.tatools.sunshine.testng;

import org.testng.ISuite;
import org.testng.TestNG;

import java.util.List;

/**
 * The {@link SunshineTestNG} class is the default configuration of TestNG defined for Sunshine.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
final class SunshineTestNG extends TestNG {

    private final List<ISuite> database;

    /**
     * Constructs the instance of TestNG without default listeners and with 0 verbose mode (no logs). All executed
     * suites will be saved to a given list.
     *
     * @param suitesHolder the list to store suites
     */
    SunshineTestNG(List<ISuite> suitesHolder) {
        super(false);
        this.database = suitesHolder;
        this.setVerbose(0);
    }

    @Override
    protected List<ISuite> runSuites() {
        final List<ISuite> suites = super.runSuites();
        this.database.addAll(suites);
        return suites;
    }
}
