package HMI.StepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.AndroidMobileUtils;

import java.io.IOException;
import java.time.Duration;

public class LogFiles {

    public static void main(String[] args) throws IOException {

        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Launching the browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().fatal("Maximized window");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Waiting for the 30 seconds!");
        driver.get("https://www.google.com/");
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Successfully launched the app");
        AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().error("Exception occurs", new Exception("Runtime Exception"));
        driver.quit();
    }
}
