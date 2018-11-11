package org.tatools.sunshine.testng;

import org.hamcrest.CustomMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.tatools.sunshine.core.*;


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
        MatcherAssert.assertThat(
                new LoadableTestNGSuite(
                        new FileSystem.Fake(),
                        this.testFolder.getRoot().getAbsolutePath() + "/custom",
                        new Condition.Fake(true)
                ).tests(),
                new SuiteFileMatcher()
        );
    }

    @Test
    public void testDefaultSuiteDirectoryCreation() throws SuiteException {
        MatcherAssert.assertThat(
                new LoadableTestNGSuite(new SunshineSuite.Fake()).tests(),
                new SuiteFileMatcher()
        );
    }


    @Test
    public void testFileSystemFilteringWithDefaultSuiteFolder() throws SuiteException {
        MatcherAssert.assertThat(
                new LoadableTestNGSuite(new FileSystem.Fake(), new Condition.Fake(true)).tests(),
                new SuiteFileMatcher()
        );
    }

    @Test
    public void testDefaultTestsFiltering() throws SuiteException {
        MatcherAssert.assertThat(
                new LoadableTestNGSuite(new Condition.Fake(false)).tests(),
                new SuiteFileMatcher()
        );
    }

    private static class SuiteFileMatcher extends CustomMatcher<File> {

        public SuiteFileMatcher() {
            super("Check existence of a suite file");
        }

        @Override
        public boolean matches(Object item) {
            final File file = (File) item;
            return file.exist();
        }
    }
}