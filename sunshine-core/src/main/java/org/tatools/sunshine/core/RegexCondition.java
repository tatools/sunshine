package org.tatools.sunshine.core;

import java.util.regex.Pattern;
import lombok.EqualsAndHashCode;

/**
 * The implementation provides an ability to use a regex pattern for analyzing an identity.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public class RegexCondition implements Condition {

    final Pattern regex;

    /**
     * Use a value of "tests-regex" system property as a regex pattern. If the system property is
     * not set, the "(.+)(Test)([\w\d]+)?" value is used.
     */
    public RegexCondition() {
        this(System.getProperty("tests-regex", "(.+)(Test)([\\w\\d]+)?"));
    }

    /**
     * Construct the object with given regex.
     *
     * @param regex the value to be complied in a {@link Pattern}
     */
    public RegexCondition(String regex) {
        this(Pattern.compile(regex));
    }

    /**
     * Construct the object with given regex.
     *
     * @param regex the value
     */
    public RegexCondition(Pattern regex) {
        this.regex = regex;
    }

    @Override
    public final boolean applicable(String identity) {
        return regex.matcher(identity).matches();
    }
}
