package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link CompositeFilesystem} class allows to represent several filesystems as an instance of
 * {@link Filesystem} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
public final class CompositeFilesystem implements Filesystem {
    private final List<Filesystem> filesystems;

    public CompositeFilesystem(List<Filesystem> filesystems) {
        this.filesystems = filesystems;
    }

    @Override
    public List<FsPath> files() throws SuiteException {
        List<FsPath> files = new ArrayList<>();
        for (Filesystem filesystem : filesystems) {
            files.addAll(filesystem.files());
        }
        return files;
    }
}
