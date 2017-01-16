package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ControlsHelper;

public class LandingPage8 extends LandingPageObject {
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";
    private static final String CSS_LOGIN_FIELD = "#register-landing-7-form-login";
    private static final String CSS_PASSWORD_FIELD ="#register-landing-7-form-password";
    private static final String XPATH_CURRENCY_USD_RADIO_BTN = "(//input[@name='currency'])[2]";
    private static final String XPATH_AGREE_CHECK_BOX = "(//input[@name='agree'])[2]";
    private static final String CSS_REGISTER_BTN = "button.btn-popup-register";
    private static final String XPATH_EMPTY_PASSWORD_ERROR = "//div[@id='popup_register-landing-8']/div/div[2]/div[2]/form/p[2]/span";
    private static final String XPATH_AGREE_ERROR ="//div[@id='popup_register-landing-8']/div/div[2]/div[2]/form/p[4]/span";

    public LandingPage8 open(){
        driver.get(PropertyLoader.URL_8);
        return new LandingPage8();
    }

    public void registerAsUsualUsd(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)), login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)),password);
        driver.findElement(By.xpath(XPATH_CURRENCY_USD_RADIO_BTN)).click();
        driver.findElement(By.xpath(XPATH_AGREE_CHECK_BOX)).click();
        driver.findElement(By.cssSelector(CSS_REGISTER_BTN)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }

    public void registerAsUsualRub(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)),password);
        driver.findElement(By.xpath(XPATH_AGREE_CHECK_BOX)).click();
        driver.findElement(By.cssSelector(CSS_REGISTER_BTN)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }

    public void isEmptyPasswordFieldErrorPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_EMPTY_PASSWORD_ERROR)));
        driver.findElement(By.xpath(XPATH_EMPTY_PASSWORD_ERROR));
    }

    public void isAgreeCheckBoxErrorPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_AGREE_ERROR)));
        driver.findElement(By.xpath(XPATH_AGREE_ERROR));

    }

    public void registerAs(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)),password);
        driver.findElement(By.xpath(XPATH_AGREE_CHECK_BOX)).click();
        driver.findElement(By.cssSelector(CSS_REGISTER_BTN)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }

    public void registerWithOutAgree(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)),password);
        driver.findElement(By.cssSelector(CSS_REGISTER_BTN)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }


}
