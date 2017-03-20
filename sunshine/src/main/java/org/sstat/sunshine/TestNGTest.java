package org.sstat.sunshine;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class TestNGTest implements Test<XmlTest> {
    private final PathToClass aClass;

    TestNGTest(String path) {
        this.aClass = new PathToClass(path);
    }

    @Override
    public XmlTest object() {
        XmlTest test = new XmlTest();
        System.out.println(aClass.toString());
        test.setName(aClass.toString());
        test.setXmlClasses(Collections.singletonList(new XmlClass(aClass.aClass(), false)));
        return test;
    }
}
