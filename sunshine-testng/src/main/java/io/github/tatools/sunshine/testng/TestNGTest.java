package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.*;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
final class TestNGTest implements Test<XmlTest> {
    private final SunshineTest test;

    TestNGTest(SunshineTest test) {
        this.test = test;
    }

    TestNGTest(String clazz) {
        this(new SunshineTestBase(clazz));
    }

    @Override
    public XmlTest object() throws TestException {
        XmlTest xmlTest = new XmlTest();
        xmlTest.setName(test.toString());
        xmlTest.setXmlClasses(Collections.singletonList(new XmlClass(test.object(), false)));
        return xmlTest;
    }

    @Override
    public boolean match(Condition condition) {
        throw new UnsupportedOperationException(
                String.format(
                        "%s is not able to handle %s condition", this.getClass().getName(), condition.getClass().getName()
                )
        );
    }
}
