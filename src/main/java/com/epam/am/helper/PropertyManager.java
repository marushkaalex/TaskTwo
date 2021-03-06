package com.epam.am.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static Properties PROPERTIES = new Properties();
    private static PropertyManager manager = null;
    private static String file;

    public static final String REGEX = "regex.properties";

    private PropertyManager(String fileName) {
        InputStream is = PropertyManager.class.getClassLoader().getResourceAsStream(fileName);
        file = fileName;
        try {
            PROPERTIES.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertyManager getManager(String fileName) {
        if (manager == null || !file.equals(fileName)) {
            manager = new PropertyManager(fileName);
        }
        return manager;
    }

    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
