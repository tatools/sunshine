package org.tatools.sunshine.core;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * The implementation allows printing of encapsulated condition to the standard output. The printing will happen only
 * once before the first usage of {@link #applicable(String)}.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.3.0
 */
public final class VerboseRegex implements Condition {

    private final RegexCondition regexCondition;
    private final boolean[] say = new boolean[]{true};
    private final PrintStream printer;

    /**
     * Construct the object.
     *
     * @param condition the condition
     */
    public VerboseRegex(RegexCondition condition) {
        this(condition, System.out);
    }

    /**
     * Construct the object.
     *
     * @param regexCondition the condition
     * @param printer        a print stream
     */
    VerboseRegex(RegexCondition regexCondition, PrintStream printer) {
        this.regexCondition = regexCondition;
        this.printer = printer;
    }

    @Override
    public boolean applicable(String identity) {
        if (say[0]) {
            this.printer.println(
                    String.format(
                            "The following pattern will be used for classes filtering: %s",
                            this.regexCondition.regex.pattern()
                    )
            );
            Arrays.fill(say, false);
        }
        return this.regexCondition.applicable(identity);
    }
}
