package Harmony.ZelioNFCStepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import manager.ServerManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.AndroidMobileUtils;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Harmony/ZelioNFCFeatures",
					 glue = {"Harmony/ZelioNFCStepDefinitions"},
	           	   plugin = {"pretty","html:test-output/cucumber-reports/HarmonyNFC-Report/cucumber-html-report/Report.html",
			                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
	           	     /*tags = "@Update"*/)

public class TestRunnerZelioNFC {
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
