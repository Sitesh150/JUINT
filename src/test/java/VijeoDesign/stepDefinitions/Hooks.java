package VijeoDesign.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import manager.DriverManager;
import manager.ServerManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AndroidMobileUtils;

import java.io.IOException;

public class Hooks {

    @Before()
    public static void appiumServerIsRunning() throws Exception {
        ServerManager.getServerInstance().startServer();
        DriverManager.getDriverInstance().initializeDriver();
        //new VideoManager().startRecording();

        Thread.sleep(5000);
        AndroidMobileUtils.getAndroidMobileUtilsInstance().handleContext();
        System.out.println("Server is started successfully!");
    }

    @After
    public static void appiumServerIsStopped(Scenario scenario) throws IOException {
        System.out.println("Server is stopped successfully!");
        //new VideoManager().stopRecording(scenario.getName());
        DriverManager.getDriverInstance().stoDriver();
        ServerManager.getServerInstance().stopServer();
    }

    @AfterStep
    public void takingScreenShotForTheFailedTestCases(Scenario scenario){
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriverInstance().getAppiumDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
