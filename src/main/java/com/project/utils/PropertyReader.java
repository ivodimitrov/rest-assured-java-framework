package com.project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final String ENV_PROPERTY = "env"; // System property for environment
    private static final String DEFAULT_ENV = "prod"; // Default environment if none is provided
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        String environment = System.getProperty(ENV_PROPERTY, DEFAULT_ENV);
        String propertiesFile = String.format("src/test/resources/config/%s.properties", environment);

        try (FileInputStream fis = new FileInputStream(propertiesFile)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + propertiesFile, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key, "0"));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}
