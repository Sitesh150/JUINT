package PLC.M262Screens;

import manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidMobileUtils;

import java.io.IOException;
import java.time.Duration;

public class M262DiagnosticScreen {

    /**
     * @implNote Creating instances and achieving POM concept
     * @method initElements
     */
    public AndroidDriver driver;

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance().getAppiumDriver(), Duration.ofSeconds(30));

    public M262DiagnosticScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * @X-Paths Getting X-paths for all the elements
     */
    @FindBy(xpath = "//ion-icon[@name='close']/../..")
    private WebElement crossButton;

    @FindBy(xpath = "//ion-card[@class='ion-activatable ripple-parent md hydrated']//ion-icon[@name='diagnostic']")
    private WebElement diagnostics;


    /**
     * @GetterMethods Creating getters method for all the private WebElements
     */
    public WebElement getCrossButton() {
        return crossButton;
    }

    public WebElement getDiagnostics() {
        return diagnostics;
    }

    /**
     * @BusinessLogics Creating business logics
     */
    public void clickOnCancelButton() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getCrossButton());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsClick(getCrossButton());
    }

    public void clickOnDiagnosticOption() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getDiagnostics());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsClick(getDiagnostics());
    }
}
