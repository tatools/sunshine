package io.github.tatools.sunshine.core;

/**
 * The {@link Attribute} interface declares a contract to work with an attribute.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
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

    final class Fake implements Attribute {

        private final String value;
        private final boolean present;

        public Fake() {
            this("", false);
        }

        public Fake(String value) {
            this(value, false);
        }

        public Fake(boolean present) {
            this("", present);
        }

        public Fake(String value, boolean present) {
            this.value = value;
            this.present = present;
        }

        @Override
        public String value() {
            return value;
        }

        @Override
        public boolean present() {
            return present;
        }
    }
}
