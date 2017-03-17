package org.sstat.sunshine;

import org.testng.TestNG;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public class UpdateClassPath implements TestNGEngineListener {
    private final URL[] urls;

    public UpdateClassPath(URL... urls) {
        this.urls = urls;
    }

    @Override
    public void beforeRun(TestNG testNG) {
        testNG.addClassLoader(new URLClassLoader(urls));
    }

    @Override
    public void afterRun(TestNG testNG) {
    }
}
