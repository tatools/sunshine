package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.Condition;
import io.github.tatools.sunshine.core.FileSystem;
import io.github.tatools.sunshine.core.SuiteException;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class JunitSuiteTest {
    @Test
    public void testDefaultSuite() throws SuiteException {
        MatcherAssert.assertThat(
                new JunitSuite(() -> Collections.emptyList()).tests(),
                Matchers.arrayWithSize(0)
        );
    }

    @Test
    public void testDefaultFileSystemAndTestsFilter() throws SuiteException {
        MatcherAssert.assertThat(
                new JunitSuite(new FileSystem.Fake(), new Condition.Fake(false)).tests(),
                Matchers.arrayWithSize(0)
        );
    }

    @Test
    public void testDefaultTestsFilter() throws SuiteException {
        MatcherAssert.assertThat(
                new JunitSuite(new Condition.Fake(false)).tests(),
                Matchers.arrayWithSize(0)
        );
    }
}