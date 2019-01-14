package org.tatools.sunshine.core;


import java.util.List;
import java.util.stream.Collectors;

/**
 * The class represents a suite of {@link SunshineTest}s which will be loaded based on given file system.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public final class SuiteFromFileSystem implements SunshineSuite {
    private final FileSystem fileSystem;

    /**
     * Construct the new instance.
     *
     * @param fileSystem a file system to build a suite. Each item (path) will be represented
     *                   by a separate {@link SunshineTest}.
     */
    public SuiteFromFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        try {
            return fileSystem.files().stream()
                    .map(f -> new TestFromFile(f.path().toString()))
                    .collect(Collectors.toList());
        } catch (FileSystemException e) {
            throw new SuiteException(e);
        }
    }
}
