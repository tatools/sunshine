package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.EngineException;
import io.github.tatools.sunshine.core.FileSystemPath;
import io.github.tatools.sunshine.core.SuiteException;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TestNGEngineTest {

    @Test
    public void run() throws EngineException {
        new TestNGEngine(() -> new FileSystemPath.Fake("src/test/resources/testng.xml")).run();
    }

    @Test(expected = EngineException.class)
    public void runWithFail() throws EngineException {
        new TestNGEngine(() -> {
            throw new SuiteException("Fail");
        }).run();
    }
}
