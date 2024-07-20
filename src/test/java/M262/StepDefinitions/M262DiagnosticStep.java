package M262.StepDefinitions;

import manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import PLC.M262Screens.M262DiagnosticScreen;

import java.io.IOException;

public class M262DiagnosticStep {

    M262DiagnosticScreen m262DiagnosticScreen =
            new M262DiagnosticScreen((AndroidDriver)
            DriverManager.getDriverInstance().getAppiumDriver());

    @Then("Click on the Cancel button at the top-left")
    public void click_on_the_cancel_button_at_the_top_left() throws IOException {
        m262DiagnosticScreen.clickOnCancelButton();
    }

    @Then("Click on the Diagnostic tile under M262 Dashboard")
    public void click_on_the_diagnostic_tile_under_m262_dashboard() throws IOException {
        m262DiagnosticScreen.clickOnDiagnosticOption();
    }
}
