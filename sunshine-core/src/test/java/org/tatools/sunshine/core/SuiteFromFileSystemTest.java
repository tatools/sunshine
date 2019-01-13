package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class SuiteFromFileSystemTest {

    @Test
    public void tests() throws SuiteException {
        MatcherAssert.assertThat(
                new SuiteFromFileSystem(new FileSystem.Fake(new FileSystemPath.Fake("a"))).tests(),
                Matchers.hasSize(1)
        );
    }
}