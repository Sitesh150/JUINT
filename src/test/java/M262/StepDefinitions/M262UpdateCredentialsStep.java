package M262.StepDefinitions;

import manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import PLC.M262Screens.M262UpdateCredentialScreen;

import java.io.IOException;


public class M262UpdateCredentialsStep {


	M262UpdateCredentialScreen m262UpdateCredentialScreen =
			new M262UpdateCredentialScreen((AndroidDriver)
			DriverManager.getDriverInstance().getAppiumDriver());


	@Given("Launch the Application and do accept and agree")
	public void launch_the_application_and_do_accept_and_agree() throws IOException {
		m262UpdateCredentialScreen.clickReadAndAcceptedCheckBox();
		m262UpdateCredentialScreen.clickOnAcceptButton();
	}

	@When("Click on plus button under home screen of Industrial Device")
	public void click_on_plus_button_under_home_screen_of_industrial_device() throws IOException {
		m262UpdateCredentialScreen.clickOnPlusButton();
	}

	@Then("Click on Select product option on the connection popup")
	public void click_on_select_product_option_on_the_connection_popup() throws IOException {
		m262UpdateCredentialScreen.clickOnSelectProductOption();
	}

	@Then("Click On PLC")
	public void click_on_plc() throws IOException {
		m262UpdateCredentialScreen.clickOnPLC();
	}

	@Then("Click On M262")
	public void click_on_m262() throws IOException {
		m262UpdateCredentialScreen.clickOnM262PLC();
	}

	@Then("Click On TM262M25MESS8T")
	public void click_on_tm262m25mess8t() throws IOException {
		m262UpdateCredentialScreen.clickOnTM262M25MESS8TProduct();
	}

	@Then("Enter Valid {string} IPAddress")
	public void enter_valid_ip_address(String ipAddress) throws IOException {
		m262UpdateCredentialScreen.enterIPAddress(ipAddress);
	}

	@Then("Enter Valid {string} Username and {string} Password")
	public void enter_valid_username_and_password(String username, String password) throws IOException {
		m262UpdateCredentialScreen.enterUserName(username);
		m262UpdateCredentialScreen.enterPassword(password);
	}

	@Then("Click On CONNECT button")
	public void click_on_connect_button() throws IOException {
		m262UpdateCredentialScreen.clickOnConnectButton();
	}

	@Then("Verify User is Logged-in successfully!")
	public void verify_user_is_logged_in_successfully() throws IOException {
		m262UpdateCredentialScreen.verifyLoginErrorMessage();
	}
}
