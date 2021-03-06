package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ControlsHelper;


public class LandingPage11 extends LandingPageObject{

    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";

    private static final String CSS_REG_LOGIN_FIELD = "#register-landing-form-login";
    private static final String CSS_REG_PASSWORD_FIELD ="#register-landing-form-password";
    private static final String XPATH_CHECK_BOX_AGREE = "(//input[@name='agree'])[2]";
    private static final String CSS_BUTTON_SUBMIT_REG = "button.btn-popup-register-landing";
    private static final String XPATH_CURRENCY_USD= "(//input[@name='currency'])[2]";
    private static final String CSS_LEFT ="a.select-cashback";
    private static final String CSS_RIGHT = "a.select-bonus";


    private static final String CSS_ERROR_EMPTY_LOGIN = "span.errors";
    private static final String XPATH_ERROR_EMPTY_PASSWORD = "//p[2]/span";
    private static final String XPATH_ERROR_EMPTY_AGREE_CHECK_BOX = "//p[4]/span";



    public LandingPage11 open(){
        driver.get(PropertyLoader.URL_11);
        return new LandingPage11();
    }


    public void registerAsUsualRub(String login, String password){
        ControlsHelper.fillTextBox( driver.findElement(By.cssSelector(CSS_REG_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_PASSWORD_FIELD)),password);
        driver.findElement(By.xpath(XPATH_CHECK_BOX_AGREE )).click();
        driver.findElement(By.cssSelector(CSS_BUTTON_SUBMIT_REG)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));

    }

    public void registerAsUsualUsd(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_LOGIN_FIELD)), login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_PASSWORD_FIELD)), password);
        driver.findElement(By.xpath(XPATH_CURRENCY_USD)).click();
        driver.findElement(By.xpath(XPATH_CHECK_BOX_AGREE )).click();
        driver.findElement(By.cssSelector(CSS_BUTTON_SUBMIT_REG)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }



    public void  clickOnRightBonus(){
        driver.findElement(By.cssSelector(CSS_RIGHT)).click();
    }

    public void  clickOnLeftCashBack(){
        driver.findElement(By.cssSelector(CSS_LEFT)).click();
    }





    public void registerWithOutAgree(String login,String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_LOGIN_FIELD)), login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_PASSWORD_FIELD)), password);
        driver.findElement(By.cssSelector(CSS_BUTTON_SUBMIT_REG)).click();
    }



    public boolean isErrorsPresent(){
        try {
            driver.findElement(By.cssSelector(CSS_ERROR_EMPTY_LOGIN));
            driver.findElement(By.xpath(XPATH_ERROR_EMPTY_PASSWORD));
            driver.findElement(By.xpath(XPATH_ERROR_EMPTY_AGREE_CHECK_BOX ));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
