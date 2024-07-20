package PLC.M262Screens;

import manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AndroidMobileUtils;

import java.io.IOException;
import java.time.Duration;

public class M262UpdateCredentialScreen {

    /**
     * @implNote Creating instances and achieving POM concept
     * @method initElements
     */
    public AndroidDriver driver;

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance().getAppiumDriver(), Duration.ofSeconds(30));

    public M262UpdateCredentialScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * @X-Paths Getting X-paths for all the elements
     */
    @FindBy(xpath = "//ion-label[text()='Read & Accepted']")
    public WebElement readAndAcceptedText;

    @FindBy(xpath = "//ion-col[@class='ion-align-self-center md hydrated']")
    public WebElement acceptButton;

    @FindBy(xpath = "//ion-fab-button")
    public WebElement plusButton;

    @FindBy(name = "product-selector")
    public WebElement selectProductOption;

    @FindBy(xpath = "//h2[text()='PLC']")
    public WebElement PLC;

    @FindBy(xpath = "//h2[text()='M262']")
    public WebElement M262;

    @FindBy(xpath = "//h2[text()='TM262M25MESS8T']")
    public WebElement TM262M25MESS8T;

    @FindBy(xpath = "//input[@placeholder='IP address']")
    public WebElement ipAddress;

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath = "//ion-button[contains(@class,'ion-color ion-color-primary')]")
    public WebElement connectButton;

    @FindBy(xpath = "//h2[text()='Error']")
    public WebElement errorLoginTitle;

    @FindBy(xpath = "//div[@class='alert-message sc-ion-alert-md']")
    public WebElement errorLoginMessage;

    /**
     * @GetterMethods Creating getters method for all the private WebElements
     */
    public WebElement getReadAndAcceptedText() {
        return readAndAcceptedText;
    }

    public WebElement getAcceptButton() {
        return acceptButton;
    }

    public WebElement getPlusButton() {
        return plusButton;
    }

    public WebElement getSelectProductOption() {
        return selectProductOption;
    }

    public WebElement getPLC() {
        return PLC;
    }

    public WebElement getM262() {
        return M262;
    }

    public WebElement getTM262M25MESS8T() {
        return TM262M25MESS8T;
    }

    public WebElement getIpAddress() {
        return ipAddress;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConnectButton() {
        return connectButton;
    }

    public WebElement getErrorLoginTitle() {
        return errorLoginTitle;
    }

    public WebElement getErrorLoginMessage() {
        return errorLoginMessage;
    }

    /**
     * @BusinessLogics Creating business logics
     */
    public void clickReadAndAcceptedCheckBox() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getReadAndAcceptedText());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsClick(getReadAndAcceptedText());
    }

    public void clickOnAcceptButton() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getAcceptButton());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsClick(getAcceptButton());
    }

    public void clickOnPlusButton() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getPlusButton());
        getPlusButton().click();
    }

    public void clickOnSelectProductOption() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getSelectProductOption());
        getSelectProductOption().click();
    }

    public void clickOnPLC() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getPLC());
        getPLC().click();
    }

    public void clickOnM262PLC() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getM262());
        getM262().click();
    }

    public void clickOnTM262M25MESS8TProduct() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getTM262M25MESS8T());
        getTM262M25MESS8T().click();
    }

    public void enterIPAddress(String ipAddress) throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getIpAddress());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsSendKeys(getIpAddress(), ipAddress);
    }

    public void enterUserName(String username) throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getUserName());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsSendKeys(getUserName(), username);
    }

    public void enterPassword(String password) throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getPassword());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsSendKeys(getPassword(), password);
    }

    public void clickOnConnectButton() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getConnectButton());
        AndroidMobileUtils.getAndroidMobileUtilsInstance().actionsClick(getConnectButton());
    }

    public void verifyLoginErrorMessage() throws IOException {
        AndroidMobileUtils.getAndroidMobileUtilsInstance().webDriverWait(getPassword());
        String getErrorLoginTitle = getErrorLoginTitle().getText();
        String getErrorMessage = getErrorLoginMessage().getText();
        System.out.println("Error Title : " + getErrorLoginTitle);
        System.out.println("Error Message : " + getErrorMessage);
        Assert.assertEquals(getErrorLoginTitle, "Error");
    }
}