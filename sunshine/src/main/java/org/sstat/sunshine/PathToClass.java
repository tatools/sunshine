package org.sstat.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public final class PathToClass {
    private final String path;

    public PathToClass(String path) {
        this.path = path;
    }

    public Class aClass() {
        try {

            return Class.forName(toString());
        } catch (ClassNotFoundException e) {
            throw new TestException(e);
        }
    }

    @Override
    public String toString() {
        return path.replaceAll("[/\\\\]", ".").replaceFirst("^\\.", "").replace(".class", "");
    }
}
