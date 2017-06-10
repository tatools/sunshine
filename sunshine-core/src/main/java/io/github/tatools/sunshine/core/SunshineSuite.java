package io.github.tatools.sunshine.core;

import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 10.06.2017
 */
public interface SunshineSuite extends Suite<List<Test<Class>>> {
    @Override
    List<Test<Class>> tests();
}
