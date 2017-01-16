package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ControlsHelper;


public class LandingPage7 extends LandingPageObject {
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";
    private static final String XPATH_100_BONUS_IMG = "(//img[@alt='100% бонус'])[2]";
    private static final String XPATH_CASH_BACK_IMG = "(//img[@alt='10% кэшбек'])[2]";
    private static final String CSS_REFUSE_GIFT = "label.link-like > span";
    private static final String CSS_LOGIN_FIELD = "#register-landing-7-form-login";
    private static final String CSS_PASSWORD_FIELD ="#register-landing-7-form-password";
    private static final String XPATH_CURRENCY_USD_RADIO_BTN = "(//input[@name='currency'])[2]";
    private static final String XPATH_AGREE_CHECK_BOX = "(//input[@name='agree'])[2]";
    private static final String CSS_REGISTER_BTN = "button.btn-popup-register";
    private static final String XPATH_EMPTY_PASSWORD_ERROR = "//div[@id='popup_register-landing-7']/div/div[2]/div[2]/form/p[2]/span";
    private static final String XPATH_AGREE_ERROR ="//div[@id='popup_register-landing-7']/div/div[2]/div[2]/form/p[4]/span";

    public LandingPage7 open(){
        driver.get(PropertyLoader.URL_7);
        return new LandingPage7();
    }

    public void choose100Bonus(){
        driver.findElement(By.xpath(XPATH_100_BONUS_IMG)).click();
    }

    public void chooseCashBack(){
        driver.findElement(By.xpath(XPATH_CASH_BACK_IMG)).click();
    }

    public void refuseGift(){
        driver.findElement(By.cssSelector(CSS_REFUSE_GIFT)).click();
    }



    public HomePage registerAsUsualUsd(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)),password);
        driver.findElement(By.xpath(XPATH_CURRENCY_USD_RADIO_BTN)).click();
        driver.findElement(By.xpath(XPATH_AGREE_CHECK_BOX)).click();
        driver.findElement(By.cssSelector(CSS_REGISTER_BTN)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new HomePage();
    }

    public HomePage registerAsUsualRub(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)),password);
        driver.findElement(By.xpath(XPATH_AGREE_CHECK_BOX)).click();
        driver.findElement(By.cssSelector(CSS_REGISTER_BTN)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new HomePage();
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
