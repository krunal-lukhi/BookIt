package fwk.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Krunal Lukhi
 * @since 06/08/23
 */
public enum PropertyResource implements PropertyStore {
    APP("app.properties", "/mnt1/config/app.properties"),
    ;
    private final String fileName;
    private final String fullPath;
    private Properties properties = new Properties();

    PropertyResource(String resourceLocation, String fullPath) throws IOException {
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
        properties.getProperty(key, defaultValue);
        return null;
    }

    /***********************************************************************************************************
     *                                           PRIVATE METHODS                                                                            *
     ***********************************************************************************************************/

    private void loadProperties(Properties properties) throws IOException, FileNotFoundException {
        properties.load(new FileInputStream(fullPath));
    }
}
