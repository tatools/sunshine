package org.sstat.sunshine;

import org.sstat.sunshine.location.Location;
import org.testng.TestNG;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public final class TestNGEngine implements Engine {

    private final TestNG engine = new TestNG(false);
    private final TestNGConfiguration configuration;
    private final Location location;

    public TestNGEngine(Location location) {
        this(location, new TestNGConfiguration() {
                 @Override
                 public void applyBeforeRun(TestNG testNG) {

                 }

                 @Override
                 public void applyAfterRun(TestNG testNG) {

                 }
             }
        );
    }

    public TestNGEngine(Location location, TestNGConfiguration configuration) {
        this.location = location;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        configuration.applyBeforeRun(engine);
        engine.setXmlSuites(Collections.singletonList(new TestNGTests(location).suite()));
        engine.run();
        configuration.applyAfterRun(engine);
        System.exit(engine.getStatus());
    }
}
