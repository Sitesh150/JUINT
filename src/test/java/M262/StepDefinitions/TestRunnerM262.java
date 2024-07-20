package M262.StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import manager.ServerManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.AndroidMobileUtils;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/PLC.M262Features",
					 glue = {"M262.StepDefinitions"},
	           	   plugin = {"pretty","html:test-output/HTMLCucumber-Reports/M262-Report/Cucumber-html-Report/Report.html",
			                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						     "json:test-output/JSONReports/M262-Report/Report.json",
						     "junit:test-output/XMLReports/M262-Report/Report.xml"},
	           	     tags =  "@Verify_Diagnose")

public class TestRunnerM262 extends AbstractTestNGCucumberTests {
	@BeforeClass
		public static void runApp() throws IOException {
		AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Starting Appium Server");
		ServerManager.getServerInstance().startServer();
		AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Appium Server successfully is started!");
	}
	@BeforeClass
	public static void notApp() throws IOException {
		AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Closing Appium Server");
		ServerManager.getServerInstance().stopServer();
		AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().info("Appium Server is closed successfully!");
	}
}
