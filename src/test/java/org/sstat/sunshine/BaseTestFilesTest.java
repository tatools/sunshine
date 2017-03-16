package org.sstat.sunshine;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.sstat.sunshine.location.Jar;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class BaseTestFilesTest {
    @Test
    public void allTests() {
        MatcherAssert.assertThat(
                new BaseTestFiles(new Jar("src/test/resources/testng-tests-0.1.0.jar")).allTests(),
                Matchers.not(Matchers.empty())
        );
    }
}