package org.sstat.sunshine;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class BaseTestFile implements TestFile {
    private final String path;

    public BaseTestFile(String path) {
        this.path = path;
    }

    @Override
    public Class<?> asClass() throws ClassNotFoundException {
        return Class.forName(className());
    }

    private String className() {
        return path.replaceAll("[/\\\\]", ".").replaceFirst("^\\.", "").replace(".class", "");
    }

    @Override
    public XmlTest asTestNGTest() {
        String name = className();
        XmlTest test = new XmlTest();
        test.setName(name);
        test.setXmlClasses(Collections.singletonList(new XmlClass(name)));
        return test;
    }
}
