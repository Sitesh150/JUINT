package manager;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;

public class CapabilitiesManager {

    /**
     * @keyword Using volatile keyword to get the proper read for all threads.
     */
    private volatile static CapabilitiesManager capabilitiesManager;
    private CapabilitiesManager() {}


    /**
     * @return capabilitiesManager
     * @implNote Double check code for driver is initiated or not.
     */
    public static CapabilitiesManager getCapabilitiesInstance(){

        if(capabilitiesManager==null){
            synchronized (CapabilitiesManager.class){
                if(capabilitiesManager==null){
                    capabilitiesManager = new CapabilitiesManager();
                }
            }
        }
        return capabilitiesManager;
    }

    /**
     * @Declaration UiAutomator2Options.
     */
    UiAutomator2Options uiAutomator2Options;

    /**
     * @Initialization UiAutomator2Options
     * @method Method to initiate the Mobile Android driver session.
     */
    public UiAutomator2Options getAndroidCapabilities() throws IOException {
        uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setCapability("appium:udId", PropertyManager.properties.getProperty("androidUdId"));
        uiAutomator2Options.setCapability("appium:deviceName", PropertyManager.properties.getProperty("androidDeviceName"));
        uiAutomator2Options.setCapability("appium:platformVersion", PropertyManager.properties.getProperty("androidPlatformVersion"));
        uiAutomator2Options.setCapability("appium:platformName", PropertyManager.properties.getProperty("androidPlatformName"));
        uiAutomator2Options.setCapability("appium:appPackage", PropertyManager.properties.getProperty("androidAppPackage"));
        uiAutomator2Options.setCapability("appium:appActivity", PropertyManager.properties.getProperty("androidAppActivity"));
        uiAutomator2Options.setCapability("appium:automationName", PropertyManager.properties.getProperty("androidAutomationName"));
        uiAutomator2Options.setCapability("appium:autoGrantPermissions", true);
        uiAutomator2Options.setCapability("autoWebView", PropertyManager.properties.getProperty("androidView"));
        uiAutomator2Options.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        uiAutomator2Options.setCapability("appium:app", PropertyManager.properties.getProperty("androidAppLocation"));
        return uiAutomator2Options;
    }


    /**
     * @Initialization UiAutomator2Options
     * @method Method to initiate the Mobile iOS driver session.
     */
    public UiAutomator2Options getIOSCapabilities() throws IOException {
        uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setCapability("iOSDeviceName", "iOSDeviceName");
        uiAutomator2Options.setCapability("iOSPlatformVersion", "iOSPlatformVersion");
        uiAutomator2Options.setCapability("iOSPlatformName", "iOSPlatformName");
        uiAutomator2Options.setCapability("iOSAutomationName", "iOSAutomationName");
        uiAutomator2Options.setCapability("bundleID", "iOSBundleID");
        uiAutomator2Options.setCapability("wdaLocalPort", "wdaLocalPort");
        uiAutomator2Options.setCapability("webKitDebugProxyPort", "webKitDebugProxyPort");
        uiAutomator2Options.setCapability("appium:app", PropertyManager.properties.getProperty("iOSAppLocation"));

        return uiAutomator2Options;
    }
}



