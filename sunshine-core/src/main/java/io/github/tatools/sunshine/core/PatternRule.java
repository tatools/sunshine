package io.github.tatools.sunshine.core;

import java.util.regex.Pattern;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
class PatternRule implements Rule {

    private final Pattern regex;

    PatternRule(Property<String> property) {
        this(property.value());
    }

    PatternRule(String regex) {
        this(Pattern.compile(regex));
    }

    PatternRule(Pattern regex) {
        this.regex = regex;
    }


    @Override
    public boolean pass(String identity) {
        return regex.matcher(identity).matches();
    }
}
