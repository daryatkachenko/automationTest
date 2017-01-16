package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ControlsHelper;


public class LandingPage4 extends LandingPageObject {

    private static final String CSS_BUTTON_REG = "div.landing-promo-2 > a";
        private static final String CSS_REG_LOGIN_FIELD = "#register-landing-form-login";
        private static final String CSS_REG_PASSWORD_FIELD ="#register-landing-form-password";
        private static final String XPATH_CHECK_BOX_AGREE = "(//input[@name='agree'])[2]";

        private static final String CSS_BUTTON_SUBMIT_REG = "button.btn-popup-register-landing";
        private static final String XPATH_CURRENCY_USD= "(//input[@name='currency'])[2]";
        private static final String CSS_POP_REG = "#popup_register-landing";


        private static final String CSS_ERROR_EMPTY_LOGIN = "span.errors";
        private static final String XPATH_ERROR_EMPTY_PASSWORD = "//div[@id='popup_register-landing']/div/div[2]/form/p[2]/span";
        private static final String XPATH_ERROR_EMPTY_AGREE_CHECK_BOX = "//div[@id='popup_register-landing']/div/div[2]/form/p[4]/span";




        public LandingPage4 open(){
            driver.get(PropertyLoader.URL_4);
            return new LandingPage4();
        }

        public void clickOnButtonRegistration(){
            driver.findElement(By.cssSelector(CSS_BUTTON_REG)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_REG)));
        }



        public void registerAsUsualRub(String login, String password){
            ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_LOGIN_FIELD)),login);
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


        public void  registerAs(String login, String password){
            ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_LOGIN_FIELD)), login);
            ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_PASSWORD_FIELD)), password);
            driver.findElement(By.xpath(XPATH_CURRENCY_USD)).click();
            driver.findElement(By.xpath(XPATH_CHECK_BOX_AGREE )).click();
            driver.findElement(By.cssSelector(CSS_BUTTON_SUBMIT_REG)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        }


        public void registerWithOutAgree(String login,String password){

            ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_LOGIN_FIELD)), login);
            ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_REG_PASSWORD_FIELD)), password);
            driver.findElement(By.cssSelector(CSS_BUTTON_SUBMIT_REG)).click();
        }


        public boolean isErrorsPresent(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_REG)));
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


