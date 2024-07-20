package manager;

import java.io.IOException;
import java.util.Properties;

public class testAndCheck {
    public static void main(String[] args) throws IOException {
        Properties properties = new PropertyManager().getPropertyData();
        System.out.println(properties.getProperty("androidPlatformName"));
    }
}
