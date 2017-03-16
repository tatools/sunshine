package org.sstat.sunshine;

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
        String className = path.replaceAll("[/\\\\]", ".").replaceFirst("^\\.", "").replace(".class", "");
        return Class.forName(className);
    }
}
