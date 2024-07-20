package ALTIVAR.StepDefinitions;

import ALTIVAR.ATV212Screens.ATV212DiagnosticScreen;
import manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class AlLTIVARDiagnosticStep {

    ATV212DiagnosticScreen altivarDiagnosticScreen =
            new ATV212DiagnosticScreen((AndroidDriver)
            DriverManager.getDriverInstance().getAppiumDriver());

    @Then("Click on the Cancel button at the top-left")
    public void click_on_the_cancel_button_at_the_top_left() throws IOException {
        altivarDiagnosticScreen.clickOnCancelButton();
    }

    @Then("Click on the Diagnostic tile under M262 Dashboard")
    public void click_on_the_diagnostic_tile_under_m262_dashboard() throws IOException {
        altivarDiagnosticScreen.clickOnDiagnosticOption();
    }
}
