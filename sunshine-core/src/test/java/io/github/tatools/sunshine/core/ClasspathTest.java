package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class ClasspathTest {

    @Test
    public void files() throws IOException {
        MatcherAssert.assertThat(new Classpath().files(), Matchers.not(Matchers.empty()));
    }
}