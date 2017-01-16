package framework.pageobject;

import framework.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dt on 05.09.2016.
 */
public abstract class PageObject {
    private static final String CSS_WELCOME_POP_UP = "#popup_welcome";
    private static final String CSS_BUTTON_SAVE_GIFT = "button.btn-save-gift";
    private static final String CSS_POP_UP_COMPLETE_REG = "#popup_complete-registration";
    private static final String XPATH_COMPLETE_REG_CHECK_BOX_AGREE = "(//input[@name='agree'])[6]";
    private static final String CSS_COMPLETE_LOGIN_FIELD = "#complete-form-login";
    private static final String CSS_BTH_COMPLETE_REG ="button.btn-popup-complete-registration";
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";
    private static final String CSS_POP_UP_AUTH = "#popup_auth";
    private static final String CSS_ERROR_EMPTY_FIELDS = "p.form-line.has-error > span.errors";
    private static final String XPATH_ERROR_WRONG_EMAIL_OR_PASSWORD = "//div[@id='popup_auth']/div/div[2]/form/p[2]/span";
    private static final String CSS_RED_HELPER = "#rh-badge";
    private static final String CSS_LOGO = "a.logo";
    private static final String CSS_FOOTER = "div.bottom-content";




    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20, 300);


    public PageObject() {
        this.wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void completeSocialRegistration(String completeRegEmail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_COMPLETE_REG)));
        driver.findElement(By.xpath(XPATH_COMPLETE_REG_CHECK_BOX_AGREE)).click();
        driver.findElement(By.cssSelector(CSS_COMPLETE_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_COMPLETE_LOGIN_FIELD)).sendKeys(completeRegEmail);
        driver.findElement(By.cssSelector(CSS_BTH_COMPLETE_REG)).click();
    }

    public HomePage welcomeGift(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_WELCOME_POP_UP)));
        driver.findElement(By.cssSelector(CSS_BUTTON_SAVE_GIFT)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new HomePage();
    }


    public void isErrorEmptyFieldsPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_AUTH)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_ERROR_EMPTY_FIELDS)));
        driver.findElement(By.cssSelector(CSS_ERROR_EMPTY_FIELDS)).isDisplayed();
    }

    public void isErrorWrongNameOrPasswordPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_AUTH)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ERROR_WRONG_EMAIL_OR_PASSWORD)));
        driver.findElement(By.xpath(XPATH_ERROR_WRONG_EMAIL_OR_PASSWORD)).isDisplayed();
    }


    public void checkRedHelper(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_RED_HELPER)));
        driver.findElement(By.cssSelector(CSS_RED_HELPER)).isDisplayed();
    }

    public void isLogoPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_LOGO)));
        driver.findElement(By.cssSelector(CSS_LOGO)).isDisplayed();
    }

    public void isRedHelperPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_RED_HELPER)));
        driver.findElement(By.cssSelector(CSS_RED_HELPER)).isDisplayed();
    }

    public void checkFooter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_FOOTER )));
        driver.findElement(By.cssSelector(CSS_FOOTER )).isDisplayed();
    }


}
