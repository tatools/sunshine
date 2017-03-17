package org.sstat.testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public class SkippedTest {
    @BeforeTest
    public void fail() {
        throw new RuntimeException();
    }

    @Test
    public void test() {
        assert true;
    }

}
