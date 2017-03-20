package org.sstat.sunshine;

import org.sstat.sunshine.location.Jar;
import org.sstat.sunshine.location.Location;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class TestNGTests implements Tests {
    private final Location location;

    public TestNGTests(Location location) {
        this.location = location;
    }

    @Override
    public XmlSuite suite() {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Sunshine default tests suit");
        for (TestNGTest testFile : testFiles(location, new ArrayList<>())) {
            XmlTest test = testFile.object();
            test.setSuite(xmlSuite);
            xmlSuite.addTest(test);
        }
        return xmlSuite;
    }

    private List<TestNGTest> testFiles(Location location, List<TestNGTest> result) {
        for (Artifact file : location.files()) {
            String path = file.asString();
            if (isClass(path)) {
                result.add(new TestNGTest(path));
            } else if (isJar(path)) {
                testFiles(new Jar(path), result);
            }
        }
        return result;
    }


    private boolean isClass(String path) {
        return path.matches(".+\\.class$") && !path.contains("$");
    }

    private boolean isJar(String path) {
        return path.endsWith(".jar");
    }
}
