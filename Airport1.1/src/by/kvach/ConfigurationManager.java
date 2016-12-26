package by.kvach;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private static final ResourceBundle resourseBundle = ResourceBundle.getBundle("by.kvach.properties.config");

    private ConfigurationManager() {}

    public static String getProperty(String key){
        return resourseBundle.getString(key);
    }
}
