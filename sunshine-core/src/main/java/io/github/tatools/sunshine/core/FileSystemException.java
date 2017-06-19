package io.github.tatools.sunshine.core;

/**
 * The {@link FileSystemException} class is a default exception to handle errors which may occur in the implementations of
 * a {@link FileSystem} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 18.03.2017
 */
public class FileSystemException extends SunshineException {
    public FileSystemException(String message) {
        super(message);
    }

    public FileSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSystemException(Throwable cause) {
        super(cause);
    }
}
