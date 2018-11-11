package org.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemOfClasspathClassesTest {

    @Test
    public void files() throws FileSystemException {
        MatcherAssert.assertThat(new FileSystemOfClasspathClasses().files(), Matchers.not(Matchers.empty()));
    }
}