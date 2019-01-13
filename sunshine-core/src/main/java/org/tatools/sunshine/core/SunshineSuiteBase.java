package org.tatools.sunshine.core;


import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 * @deprecated please use {@link SuiteFromFileSystem} instead of this class.
 */
@Deprecated
public final class SunshineSuiteBase implements SunshineSuite {
    private final SunshineSuite suite;

    public SunshineSuiteBase(FileSystem fileSystem) {
        this.suite = new SuiteFromFileSystem(fileSystem);
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        return this.suite.tests();
    }
}
