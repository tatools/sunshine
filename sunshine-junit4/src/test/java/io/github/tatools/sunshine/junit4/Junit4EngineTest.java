package io.github.tatools.sunshine.junit4;

import io.github.tatools.sunshine.core.EngineException;
import io.github.tatools.sunshine.core.SuiteException;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 04.07.2017
 */
public class Junit4EngineTest {

    @Test
    public void run() throws EngineException {
        new Junit4Engine(() -> new Class[]{}).run();
    }

    @Test(expected = EngineException.class)
    public void runWithFail() throws EngineException {
        new Junit4Engine(() -> {
            throw new SuiteException("Fail");
        }).run();
    }
}
