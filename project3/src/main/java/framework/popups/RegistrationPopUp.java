package framework.popups;

import framework.pageobject.PageObject;
import framework.utils.ControlsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 05.09.2016.
 */
public class RegistrationPopUp extends PageObject {

    private static final String CSS_BTN_REGISTER_TOP ="a.btn-registration-top > span";
    private static final String CSS_REGISTER_LOGIN_FIELD = "#register-form-login";
    private static final String CSS_REGISTER_PASSWORD_FIELD = "#register-form-password";
    private static final String XPATH_CHECK_BOX_AGREE = "(//input[@name='agree'])[2]";
    private static final String XPATH_RADIO_BUTTON_USD = "(//input[@name='currency'])[2]";
    private static final String CSS_BTH_SUBMIT_REGISTRATION = "button.btn-popup-register";
    private static final String CSS_POP_UP_REGISTRATION = "#popup_register";

    private static final String CSS_ERROR_WITH_OUT_AGREE = "//div[@id='popup_register']/div/div[2]/form/p[4]/span";
    private static final String CSS_ERROR_EMPTY_FIELDS = "//div[@id='popup_register']/div/div[2]/form/p[2]/span";
    private static final String CSS_ERROR_ENTER_VALID_EMAIL ="p.form-line.has-error > span.errors";

    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";




    public RegistrationPopUp open() {
        driver.findElement(By.cssSelector(CSS_BTN_REGISTER_TOP)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_REGISTRATION)));
        return new RegistrationPopUp();
    }




    public void registrationAsUsualRub(String login, String password){
        driver.findElement(By.cssSelector(CSS_REGISTER_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_REGISTER_LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.cssSelector(CSS_REGISTER_PASSWORD_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_REGISTER_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(XPATH_CHECK_BOX_AGREE )).click();
        driver.findElement(By.cssSelector(CSS_BTH_SUBMIT_REGISTRATION)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }

    public void registrationAsUsualUsd(String login, String password){
        driver.findElement(By.cssSelector(CSS_REGISTER_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_REGISTER_LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.cssSelector(CSS_REGISTER_PASSWORD_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_REGISTER_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(XPATH_RADIO_BUTTON_USD)).click();
         driver.findElement(By.xpath(XPATH_CHECK_BOX_AGREE )).click();
        driver.findElement(By.cssSelector(CSS_BTH_SUBMIT_REGISTRATION)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }

    public void registrationAs(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REGISTER_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REGISTER_PASSWORD_FIELD)),password);
        driver.findElement(By.xpath(XPATH_CHECK_BOX_AGREE )).click();
        driver.findElement(By.cssSelector(CSS_BTH_SUBMIT_REGISTRATION)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }

    public void registrationWithOutAgree(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REGISTER_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REGISTER_PASSWORD_FIELD)),password);
        driver.findElement(By.cssSelector(CSS_BTH_SUBMIT_REGISTRATION)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }

    public void isErrorRegisterWithoutAgreePresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CSS_ERROR_WITH_OUT_AGREE)));
        driver.findElement(By.xpath(CSS_ERROR_WITH_OUT_AGREE)).isDisplayed();
    }

    public void isEmptyFieldsErrorPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CSS_ERROR_EMPTY_FIELDS)));
        driver.findElement(By.xpath(CSS_ERROR_EMPTY_FIELDS)).isDisplayed();
    }

    public void isErrorEnterRealEmailPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_ERROR_ENTER_VALID_EMAIL)));
        driver.findElement(By.cssSelector(CSS_ERROR_ENTER_VALID_EMAIL)).isDisplayed();
    }









}
