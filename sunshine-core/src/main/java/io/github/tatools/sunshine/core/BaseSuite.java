package io.github.tatools.sunshine.core;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 20.03.2017
 */
public final class BaseSuite implements SunshineSuite {
    // @todo #99:1h Make names self-explained for SunshineSuite implementaions.
    private final FileSystem fileSystem;

    public BaseSuite(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        try {
            return fileSystem.files().stream().map(f -> new BaseTest(f.path().toString())).collect(Collectors.toList());
        } catch (FileSystemException e) {
            throw new SuiteException(e);
        }
    }
}
