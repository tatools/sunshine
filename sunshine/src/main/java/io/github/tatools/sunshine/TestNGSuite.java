package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public interface TestNGSuite extends Suite<File> {
    /**
     * Return a TestNG tests file.
     *
     * @return an instance of {@link File}.
     */
    @Override
    File tests();
}
