package com.softserveinc.sstat.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
final class TestClass {
    private final String path;

    TestClass(String path) {
        this.path = path;
    }

    Class aClass() {
        try {
            return Class.forName(toString());
        } catch (ClassNotFoundException e) {
            throw new TestClassException(e);
        }
    }

    @Override
    public String toString() {
        return path.replaceAll("[/\\\\]", ".").replaceFirst("^\\.", "").replace(".class", "");
    }
}
