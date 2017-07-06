package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.regex.Pattern;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public final class RegexCondition implements Condition {

    private final Pattern regex;

    public RegexCondition(Attribute attribute) {
        this(attribute.value());
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
