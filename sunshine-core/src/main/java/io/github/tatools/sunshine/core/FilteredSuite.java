package io.github.tatools.sunshine.core;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class FilteredSuite implements Suite<List<Test<Class>>> {

    private final Suite<List<Test<Class>>> suite;
    private final Rule filter;

    public FilteredSuite(Suite<List<Test<Class>>> suite, Rule filter) {
        this.suite = suite;
        this.filter = filter;
    }

    @Override
    public List<Test<Class>> tests() {
        return suite.tests().stream().filter(classTest -> classTest.match(filter)).collect(Collectors.toList());
    }
}
