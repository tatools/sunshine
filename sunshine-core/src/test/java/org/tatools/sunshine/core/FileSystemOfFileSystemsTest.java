package org.tatools.sunshine.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemOfFileSystemsTest {
    @Test
    public void files() throws FileSystemException {
        List<FileSystem> fileSystems =
                Arrays.asList(
                        new FileSystem.Fake(Collections.singletonList(new FileSystemPath.Fake())),
                        new FileSystem.Fake(Collections.singletonList(new FileSystemPath.Fake())));
        MatcherAssert.assertThat(
                new FileSystemOfFileSystems(fileSystems).files(), Matchers.hasSize(2));
    }
}
