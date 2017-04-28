package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class SunshineTestsFilter implements Rule {

    private final Rule rule;

    public SunshineTestsFilter(Config config) {
        this(new PatternRule(new TurnProperty<>(new SystemTestsPattern(), new DefaultTestsPattern(config))));
    }

    private SunshineTestsFilter(Rule rule) {
        this.rule = rule;
    }

    @Override
    public boolean pass(String identity) {
        return rule.pass(identity);
    }
}
