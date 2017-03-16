package org.sstat.sunshine;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.sstat.sunshine.location.Location;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class BaseTestFileTest {

    @Test(expected = ClassNotFoundException.class)
    public void asClassWithGhostClass() throws ClassNotFoundException {
        new BaseTestFile("org/sstat/testng/Test1.class").asClass();
    }

    @Test
    public void withRealClass() throws ClassNotFoundException {
        MatcherAssert.assertThat(
                new BaseTestFile("org/sstat/sunshine/location/Location.class").asClass(),
                Matchers.equalTo(Location.class)
        );
    }
}