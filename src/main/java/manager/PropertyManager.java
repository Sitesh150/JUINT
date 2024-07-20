package manager;

import utils.AndroidMobileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    public static Properties properties = new Properties();

    /**
     * @return properties
     * @method To get the property file Data
     */

    public Properties getPropertyData() throws IOException {
        InputStream inputStream = null;
        String propertyFileName = "config.properties";
        if (properties.isEmpty()) {
            try {
                AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Loading Property File");
                inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
                properties.load(inputStream);
            } catch (Exception e) {
                AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Property File is not Loaded  ABORT!");
                throw new RuntimeException(e);
            }
            finally {
                if(inputStream != null){
                    inputStream.close();
                }
            }
        }
        return properties;
    }
}
