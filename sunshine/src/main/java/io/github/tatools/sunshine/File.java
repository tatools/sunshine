package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
interface File extends FsPath {
    void write(String data);
}
