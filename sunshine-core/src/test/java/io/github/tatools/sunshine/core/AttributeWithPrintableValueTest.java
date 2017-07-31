package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AttributeWithPrintableValueTest {

    @Test
    public void value() {
        final Attribute.Fake fake = new Attribute.Fake();
        MatcherAssert.assertThat(
                new AttributeWithPrintableValue("", fake).value(),
                Matchers.is(fake.value())
        );
    }

    @Test
    public void present() {
        final Attribute.Fake fake = new Attribute.Fake();
        MatcherAssert.assertThat(
                new AttributeWithPrintableValue("", fake).present(),
                Matchers.is(fake.present())
        );
    }
}