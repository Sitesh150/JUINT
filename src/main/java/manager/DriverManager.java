package manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import utils.AndroidMobileUtils;

import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    /**
     * @keyword Using volatile keyword to get the proper read for all threads.
     */
    private volatile static DriverManager driverManager;
    private DriverManager() {}


    /**
     * @return driverManager
     * @implNote Double check code for driver is initiated or not.
     */
    public static DriverManager getDriverInstance(){

        if(driverManager==null){
            synchronized (DriverManager.class){
                if(driverManager==null){
                    driverManager = new DriverManager();
                }
            }
        }
        return driverManager;
    }


    /**
     * @class ThreadLocal to only allows to read not write
     */
    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    /**
     * @return appiumDriver
     * @method Getting the appiumDriver
     */
    public AppiumDriver getAppiumDriver(){
        return appiumDriver.get();
    }

    /**
     * @method Setting the appiumDriver
     */
    public void setAppiumDriver(AppiumDriver _appiumDriver){
        appiumDriver.set(_appiumDriver);
    }

    /**
     * @method Launching the App and initializing the driver based on the platform name
     */
    public void initializeDriver() throws Exception {
        AppiumDriver appiumDriver;
        Properties properties = new PropertyManager().getPropertyData();

        try {
            if (PropertyManager.properties.getProperty("androidPlatformName").equalsIgnoreCase(PropertyManager.properties.getProperty("androidPlatformName"))) {
                appiumDriver = new AndroidDriver(ServerManager.getServerInstance().getServer().getUrl(),
                        CapabilitiesManager.getCapabilitiesInstance().getAndroidCapabilities());

            } else if (PropertyManager.properties.getProperty("iOSPlatformName").equalsIgnoreCase(PropertyManager.properties.getProperty("iOSPlatformName"))) {
                appiumDriver = new IOSDriver(ServerManager.getServerInstance().getServer().getUrl(),
                        CapabilitiesManager.getCapabilitiesInstance().getIOSCapabilities());

            } else throw new RuntimeException("Please Provide Valid Mobile OS Name!");
            AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("OS name Matched & Continued with the same platform!");

            if (appiumDriver == null) {
                throw new Exception("driver is getting NULL, ABORT!!");
            }
            DriverManager.appiumDriver.set(appiumDriver);
        } catch (IOException e) {
            AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().error("No driver Found!", new Exception("Driver is NULL!"));
            throw new RuntimeException(e);
        } catch (Exception e) {
            AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().error("No driver Found!", new Exception("Driver is NULL!"));
        }
    }

    /**
     * @method Stopping the App and checking if driver is still running
     */
    public void stoDriver() {
        if (appiumDriver != null) {

            try {
                appiumDriver.get().quit();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
