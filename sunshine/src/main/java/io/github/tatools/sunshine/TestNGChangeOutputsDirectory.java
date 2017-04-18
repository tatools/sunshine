package io.github.tatools.sunshine;

import org.testng.TestNG;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * The {@link TestNGCompositeConfiguration} class allows to configure an output directory for TestNG. This directory will
 * be used to store different reports (Junit XMLs etc.).
 * <p>Previous testing results will be deleted before next run.</p>
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @todo #26 Move this logic as a separate part os sunshine, not TestNGEngine configuration.
 * @since 29.03.2017
 */
public final class TestNGChangeOutputsDirectory implements TestNGConfiguration {

    private final String directoryPath;

    public TestNGChangeOutputsDirectory(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public void apply(TestNG testNG) {
        try {
            Path path = Paths.get(directoryPath);
            Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
        }
        testNG.setOutputDirectory(directoryPath);
    }
}
