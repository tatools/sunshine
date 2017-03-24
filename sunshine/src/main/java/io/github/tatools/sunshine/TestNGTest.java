package io.github.tatools.sunshine;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
final class TestNGTest implements Test<XmlTest> {
    private final TestClass testClass;

    TestNGTest(TestClass testClass) {
        this.testClass = testClass;
    }

    TestNGTest(String clazz) {
        this(new TestClass(clazz));
    }

    @Override
    public XmlTest object() {
        XmlTest test = new XmlTest();
        System.out.println(testClass.toString());
        test.setName(testClass.toString());
        test.setXmlClasses(Collections.singletonList(new XmlClass(testClass.aClass(), false)));
        return test;
    }
}
