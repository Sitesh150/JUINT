package VijeoDesign.stepDefinitions;

import HMI.HMIScreens.HMIUpdateCredentialScreen;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverManager;

import java.io.IOException;


public class VijeoDesignUpdateCredentialsStep {


	HMIUpdateCredentialScreen hmiUpdateCredentialScreen =
			new HMIUpdateCredentialScreen((AndroidDriver)
			DriverManager.getDriverInstance().getAppiumDriver());


	@Given("Launch the Application and do accept and agree")
	public void launch_the_application_and_do_accept_and_agree() throws IOException {
		hmiUpdateCredentialScreen.clickReadAndAcceptedCheckBox();
		hmiUpdateCredentialScreen.clickOnAcceptButton();
	}

	@When("Click on plus button under home screen of Industrial Device")
	public void click_on_plus_button_under_home_screen_of_industrial_device() throws IOException {
		hmiUpdateCredentialScreen.clickOnPlusButton();
	}

	@Then("Click on Select product option on the connection popup")
	public void click_on_select_product_option_on_the_connection_popup() throws IOException {
		hmiUpdateCredentialScreen.clickOnSelectProductOption();
	}

	@Then("Click On PLC")
	public void click_on_plc() throws IOException {
		hmiUpdateCredentialScreen.clickOnPLC();
	}

	@Then("Click On M262")
	public void click_on_m262() throws IOException {
		hmiUpdateCredentialScreen.clickOnM262PLC();
	}

	@Then("Click On TM262M25MESS8T")
	public void click_on_tm262m25mess8t() throws IOException {
		hmiUpdateCredentialScreen.clickOnTM262M25MESS8TProduct();
	}

	@Then("Enter Valid {string} IPAddress")
	public void enter_valid_ip_address(String ipAddress) throws IOException {
		hmiUpdateCredentialScreen.enterIPAddress(ipAddress);
	}

	@Then("Enter Valid {string} Username and {string} Password")
	public void enter_valid_username_and_password(String username, String password) throws IOException {
		hmiUpdateCredentialScreen.enterUserName(username);
		hmiUpdateCredentialScreen.enterPassword(password);
	}

	@Then("Click On CONNECT button")
	public void click_on_connect_button() throws IOException {
		hmiUpdateCredentialScreen.clickOnConnectButton();
	}

	@Then("Verify User is Logged-in successfully!")
	public void verify_user_is_logged_in_successfully() throws IOException {
		hmiUpdateCredentialScreen.verifyLoginErrorMessage();
	}
}
