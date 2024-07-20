package VijeoDesignScreen;

import io.appium.java_client.android.AndroidDriver;
import manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidMobileUtils;

import java.io.IOException;
import java.time.Duration;

public class VijeoDesignDiagnosticScreen {

    /**
     *  Creating instances and achieving POM concept
     */
    public AndroidDriver driver;

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance().getAppiumDriver(), Duration.ofSeconds(30));

    public VijeoDesignDiagnosticScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     *  Getting X-paths for all the elements
     */
    @FindBy(xpath = "//ion-icon[@name='close']/../..")
    private WebElement crossButton;

    @FindBy(xpath = "//ion-card[@class='ion-activatable ripple-parent md hydrated']//ion-icon[@name='diagnostic']")
    private WebElement diagnostics;


    /**
     *  Creating getters method for all the private elements
     */
    public WebElement getCrossButton() {
        return crossButton;
    }

    public WebElement getDiagnostics() {
        return diagnostics;
    }

    /**
     *  Creating business logics
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
