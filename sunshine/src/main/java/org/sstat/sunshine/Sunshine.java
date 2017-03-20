package org.sstat.sunshine;

import org.sstat.sunshine.location.Classpath;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class Sunshine {
    public static void main(String[] args) {
        new TestNGEngine(new Classpath()).run();
    }
}
