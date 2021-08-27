package util.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;


public class ReadConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ReadConfig.class);

    /*
     *   Use to get property value from config.properties file
     *   example:
     *       getProperty(propertyName)
     */
    public static String getConfigProperty(String property) {
        return Objects.requireNonNull(loadPropertiesFile("config.properties").getProperty(property));
    }

    public static String getCredProperty(String property) {
        return Objects.requireNonNull(loadPropertiesFile("cred.properties").getProperty(property));
    }


    /*
     *   Use to get preprod, qa02, qa03 config files
     *   example:
     *       loadPropertiesFile().getProperties(propertiesName)
     */
    public static Properties loadPropertiesFile(String fileName) {
        Properties properties = new Properties();
        try (InputStream resourceAsStream = ReadConfig.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            LOG.error("Unable to load properties file : " + fileName);
        }
        return properties;
    }
}
