package org.tatools.sunshine.core;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface File extends FileSystemPath {
    void write(String data) throws IOException;
}
