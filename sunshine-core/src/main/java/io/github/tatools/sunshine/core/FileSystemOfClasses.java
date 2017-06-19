package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The {@link FileSystemOfClasses} class allows to select only Java classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.06.2017
 */
@EqualsAndHashCode
final class FileSystemOfClasses implements FileSystem {

    private final FileSystem fileSystem;

    FileSystemOfClasses(FileSystem fileSystem) {
        this.fileSystem = new FileSystemFiltered(
                new FileSystemOfFileSystems(
                        fileSystem,
                        new FileSystemOfJarFiles(new FileSystemFiltered(fileSystem, new JarCondition()))
                ), new ClassCondition()
        );
    }

    @Override
    public List<FsPath> files() throws FileSystemException {
        return fileSystem.files();
    }

    private final class ClassCondition implements Condition {
        @Override
        public boolean applicable(String identity) {
            return identity.matches(".+\\.class$") && !identity.contains("$");
        }
    }


    private final class JarCondition implements Condition {
        @Override
        public boolean applicable(String identity) {
            return identity.endsWith(".jar");
        }
    }
}
