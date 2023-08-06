package fwk.property;

import fwk.common.LoggingUtils;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * author Krunal Lukhi
 * since 06/08/23
 */
public enum PropertyResource implements PropertyStore {
    APP("app.properties", "/mnt1/config/app.properties"),
    ;
    private static final Logger LOGGER = LoggingUtils.getLogger(PropertyResource.class);
    private final String fileName;
    private final String fullPath;
    private Properties properties = new Properties();

    PropertyResource(String resourceLocation, String fullPath) {
        this.fileName = resourceLocation;
        this.fullPath = fullPath;
        loadProperties(this.properties);
    }

    @Override
    public String fetchProperty(String key) {
        return properties.getProperty(key);
    }

    @Override
    public String fetchProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue); // Return the fetched value
    }

    /***********************************************************************************************************
     * PRIVATE METHODS
     ***********************************************************************************************************/

    private void loadProperties(Properties properties) {
        try {
            properties.load(new FileInputStream(fullPath));
        } catch (Exception e) {
            LOGGER.error("Could not load file {}", fullPath);
            throw new RuntimeException(e);
        }
    }
}
