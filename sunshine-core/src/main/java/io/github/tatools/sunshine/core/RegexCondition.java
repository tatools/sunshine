package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.regex.Pattern;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 22.04.2017
 */
@EqualsAndHashCode
public final class RegexCondition implements Condition {

    private final Pattern regex;

    public RegexCondition(Property property) {
        this(property.value());
    }

    public RegexCondition(String regex) {
        this(Pattern.compile(regex));
    }

    public RegexCondition(Pattern regex) {
        this.regex = regex;
    }

    @Override
    public boolean applicable(String identity) {
        return regex.matcher(identity).matches();
    }
}
