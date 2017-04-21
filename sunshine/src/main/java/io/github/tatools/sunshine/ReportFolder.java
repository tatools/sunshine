package io.github.tatools.sunshine;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public class ReportFolder implements Property<String> {

    private final Config config;

    public ReportFolder(Config config) {
        this.config = config;
    }

    @Override
    public String value() {
        return config.property("reports-path");
    }
}
