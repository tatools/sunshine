package org.sstat.sunshine.location;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.sstat.sunshine.Artifact;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class JarTest {
    @Test
    public void files() {
        MatcherAssert.assertThat(
                new Jar("src/test/resources/testng-tests-0.1.0.jar").files(),
                Matchers.hasItem(new Artifact("org/sstat/testng/Test1.class"))
        );
    }
}