package io.github.tatools.sunshine.core;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
public interface TestNGSuite extends Suite<FsPath> {
    /**
     * Return a TestNG tests file.
     *
     * @return an instance of {@link FsPath}.
     */
    @Override
    FsPath tests();
}
