package io.github.tatools.sunshine;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
final class TestNGTest implements Test<XmlTest> {
    private final Test<Class> test;

    TestNGTest(Test<Class> test) {
        this.test = test;
    }

    TestNGTest(String clazz) {
        this(new ClassAsTest(clazz));
    }

    @Override
    public XmlTest object() {
        XmlTest xmlTest = new XmlTest();
        System.out.println(test.toString());
        xmlTest.setName(test.toString());
        xmlTest.setXmlClasses(Collections.singletonList(new XmlClass(test.object(), false)));
        return xmlTest;
    }

    @Override
    public boolean match(Rule rule) {
        throw new UnsupportedOperationException(
                String.format(
                        "%s is not able to handle %s rule", this.getClass().getName(), rule.getClass().getName()
                )
        );
    }
}
