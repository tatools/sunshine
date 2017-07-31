package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AttributeWithPrintableValue implements Attribute {

    private final String message;
    private final Attribute attribute;

    public AttributeWithPrintableValue(String message, Attribute attribute) {
        this.message = message;
        this.attribute = attribute;
    }

    @Override
    public String value() {
        final String value = attribute.value();
        System.out.println(new StringBuilder(this.message).append(" ").append(value));
        return value;
    }

    @Override
    public boolean present() {
        return attribute.present();
    }
}
