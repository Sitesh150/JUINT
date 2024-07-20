package M262.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import manager.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import manager.ServerManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AndroidMobileUtils;

import java.io.IOException;

public class Hooks {

    @Before
    public static void sessionStart() throws Exception {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Launching Mobile Application");
        DriverManager.getDriverInstance().initializeDriver();
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Mobile Application is launched successfully!");
        Thread.sleep(5000);
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Handling contexts");
        AndroidMobileUtils.getAndroidMobileUtilsInstance().handleContext();
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Context is handled successfully!");
    }

    @After
    public static void sessionStop() throws IOException, InterruptedException {
        System.out.println("Driver is stopped successfully!");
        Thread.sleep(2000);
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Killing the Mobile Application");
        DriverManager.getDriverInstance().stoDriver();
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Mobile Application is killed successfully!");
    }

    @AfterStep
    public void takingScreenShotForTheFailedTestCases(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriverInstance().getAppiumDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().error("Screenshot is taken successfully!", new Exception("This Step is failed!"));
        }
    }
}
