package io.github.tatools.sunshine.core;

/**
 * The {@link Attribute} interface declares a contract to work with an attribute.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public interface Attribute {
    /**
     * Allows to get a value of current attribute if it exists.
     *
     * @return a value of this attribute
     */
    String value();

    /**
     * Allows to check is this attribute set or not.
     *
     * @return <i>true</i> if this attribute exists otherwise <i>false</i>.
     */
    boolean present();
}
