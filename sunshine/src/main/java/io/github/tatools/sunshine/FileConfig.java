package io.github.tatools.sunshine;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class FileConfig implements Config {

    private final InputStream file;

    public FileConfig(InputStream file) {
        this.file = file;
    }

    @Override
    public String property(String key) {
        try {
            Properties property = new Properties();
            property.load(file);
            return property.getProperty(key, "not defined");
        } catch (java.io.IOException e) {
            throw new IOException(e);
        }
    }
}
