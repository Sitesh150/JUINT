package VijeoDesign.stepDefinitions;

import HMI.HMIScreens.HMIDiagnosticScreen;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import manager.DriverManager;

import java.io.IOException;

public class VijeoDesignDiagnosticStep {

    HMIDiagnosticScreen hmiDiagnosticScreen =
            new HMIDiagnosticScreen((AndroidDriver)
            DriverManager.getDriverInstance().getAppiumDriver());

    @Then("Click on the Cancel button at the top-left")
    public void click_on_the_cancel_button_at_the_top_left() throws IOException {
        hmiDiagnosticScreen.clickOnCancelButton();
    }

    @Then("Click on the Diagnostic tile under M262 Dashboard")
    public void click_on_the_diagnostic_tile_under_m262_dashboard() throws IOException {
        hmiDiagnosticScreen.clickOnDiagnosticOption();
    }
}
