package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
final class ClassAsTest implements Test<Class> {
    private final String path;

    ClassAsTest(String path) {
        this.path = path;
    }

    @Override
    public Class object() {
        try {
            return Class.forName(toString());
        } catch (ClassNotFoundException e) {
            throw new TestClassException(e);
        }
    }

    @Override
    public boolean match(Rule rule) {
        return rule.pass(this.toString());
    }

    @Override
    public String toString() {
        return path.replaceAll("[/\\\\]", ".").replaceFirst("^\\.", "").replace(".class", "");
    }
}
