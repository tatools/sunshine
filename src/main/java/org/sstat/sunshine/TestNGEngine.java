package org.sstat.sunshine;

import org.testng.TestNG;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public class TestNGEngine implements Engine {

    private final TestNG engine;
    private final TestNGEngineListener listener;

    public TestNGEngine() {
        this(new TestNGEngineListener() {
                 @Override
                 public void beforeRun(TestNG testNG) {

                 }

                 @Override
                 public void afterRun(TestNG testNG) {

                 }
             }
        );
    }

    public TestNGEngine(TestNGEngineListener listener) {
        this(new TestNG(false), listener);
    }

    private TestNGEngine(TestNG engine, TestNGEngineListener listener) {
        this.engine = engine;
        this.listener = listener;
    }

    @Override
    public void run(TestFiles testFiles) {
        listener.beforeRun(engine);
        engine.setXmlSuites(Collections.singletonList(testFiles.asTestNGSuite()));
        engine.run();
        listener.afterRun(engine);
    }
}
