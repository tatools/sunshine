package org.tatools.sunshine.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.3.0
 */
public class VerboseRegexTest {

    @Test
    public void testIfMessageIsDisplayedOnce() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        final VerboseRegex regex =
                new VerboseRegex(new RegexCondition("ddd"), new PrintStream(result));
        regex.applicable("a");
        regex.applicable("b");
        MatcherAssert.assertThat(
                new String(result.toByteArray()),
                Matchers.is("The following pattern will be used for classes filtering: ddd\n"));
    }
}
