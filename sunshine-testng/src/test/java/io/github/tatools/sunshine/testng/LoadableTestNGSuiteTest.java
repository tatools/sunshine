package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.Condition.Fake;
import io.github.tatools.sunshine.core.SuiteException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.ArrayList;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class LoadableTestNGSuiteTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void testAutomaticSuiteDirectoryCreation() throws SuiteException {
        new LoadableTestNGSuite(
                ArrayList::new,
                this.testFolder.getRoot().getAbsolutePath() + "/custom",
                new Fake(true)
        ).tests();
    }
}