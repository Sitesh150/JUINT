package utils;

import manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class AndroidMobileUtils {

	/**
	 * @keyword Using volatile keyword to get the proper read for all threads.
	 */
	private volatile static AndroidMobileUtils androidMobileUtils;
	private AndroidMobileUtils() {}

	/**
	 * @implNote Singlton Class - Double check code for androidMobileUtils is initiated or not.
	 */
	public static AndroidMobileUtils getAndroidMobileUtilsInstance() throws IOException {

		if(androidMobileUtils==null){
			synchronized (AndroidMobileUtils.class){
				if(androidMobileUtils==null){
					androidMobileUtils = new AndroidMobileUtils();
				}
			}
		}
		return androidMobileUtils;
	}

	/**
	 * @method Getting all the contexts and switching to the WEBVIEW.
	 */
	public void handleContext() throws InterruptedException {
		Set<String> contextNames = ((AndroidDriver) DriverManager.getDriverInstance().getAppiumDriver()).getContextHandles();
		Thread.sleep(2000);
		System.out.println(contextNames);
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")) {
				((AndroidDriver) DriverManager.getDriverInstance().getAppiumDriver()).context(contextName);
				System.out.println("========"+contextName);
				break;
			}

			if (contextName.contains("AUTO_WEBVIEW")) {
				((AndroidDriver) DriverManager.getDriverInstance().getAppiumDriver()).context(contextName);
				System.out.println(contextName);
				System.out.println("========"+contextName);
				break;
			}
		}
	}

	/**
	 * @method Action clicks to the particular element.
	 */
	public void actionsClick(WebElement element) {
		Actions actions = new Actions(DriverManager.getDriverInstance().getAppiumDriver());
		actions.moveToElement(element).click().build().perform();
	}

	/**
	 * @method Handling Alert Popup.
	 * @Exception Alert handle Exception!
	 */
	public void alertPopup() throws IOException {
		try {
			Alert alert = DriverManager.getDriverInstance().getAppiumDriver().switchTo().alert();
			String alertText = alert.getText();
			System.out.println(
					"======================================================== Alert pop-up ========================================================");
			System.out.println(alertText);
		} catch (UnhandledAlertException e) {
			AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().error("Alert is Not handled", new Exception("Alert handle Exception!"));
			throw  new RuntimeException();
		}
	}

	/**
	 * @method SendKeys value by using Actions.
	 */
	public void actionsSendKeys(WebElement element, String string) {
		Actions actions = new Actions(DriverManager.getDriverInstance().getAppiumDriver());
		actions.sendKeys(element, string).build().perform();
	}

	/**
	 * @method SendKeys value by using Actions overloaded method.
	 */
	public void actionsSendKeys(String string) {
		Actions actions = new Actions(DriverManager.getDriverInstance().getAppiumDriver());
		actions.sendKeys(string).perform();
	}

	/**
	 * @method WebDriverWait to wait for the clickable element.
	 *
	 */
	public void webDriverWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance().getAppiumDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * @method Getting log to get the info, error and debug
	 * @return LogManager
	 */
	public Logger getLog(){
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
}
