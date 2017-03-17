package org.sstat.sunshine;

import org.testng.xml.XmlSuite;

import java.util.List;

/**
 * The interface represents some test classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public interface TestFiles {

    List<TestFile> allTests();

    XmlSuite asTestNGSuite();
}
