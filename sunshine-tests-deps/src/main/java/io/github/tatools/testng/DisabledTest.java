package io.github.tatools.testng;

import org.testng.annotations.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public class DisabledTest {
    @Test(enabled = false)
    public void test() {
        assert false;
    }
}
