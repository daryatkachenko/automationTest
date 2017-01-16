package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by dt on 05.09.2016.
 */
public class RegistrationPopUp extends PageObject {
    public static final String CSS_REGISTER_BUTTON = "a.reg";
    public static final String CSS_REGISTER_EMAIL_FIELD = "#popup-register-email";
    public static final String CSS_REGISTER_PASSWORD_FIELD = "#popup-register-password";
    public static final String CSS_REGISTER_CONFIRM_PASSWORD_FIELD = "#popup-register-password-confirm";
    public static final String CSS_REGISTER_NAME_FIELD  = "#popup-register-name";
    public   static final String CSS_SKYPE_FIELD ="#popup-register-skype";
    public static final String CSS_REGISTER_PHONE_FIELD ="#popup-register-phone";
    public  static final String CSS_REG_SUBMIT_BUTTON = "button.btn-register";
    private static final  String CSS_WELCOME_POP_UP = "div.welcome-popup > h2";
    public static final String CSS_BUTTON_CLOSE_WELCOME_POP_UP ="a.btn-close";

    public RegistrationPopUp open() {
        driver.get(PropertyLoader.URL);
        return new RegistrationPopUp();
    }

    public void registrationAs(String login, String password, String confirmPassword,String name, String skype, String telephone){
        WebElement registrationButton =  driver.findElement(By.cssSelector(CSS_REGISTER_BUTTON));
        registrationButton.click();
        WebElement registrationEmail =   driver.findElement(By.cssSelector(CSS_REGISTER_EMAIL_FIELD));
        registrationEmail.clear();
        registrationEmail.sendKeys(login);
        WebElement registrationPassword = driver.findElement(By.cssSelector(CSS_REGISTER_PASSWORD_FIELD));
        registrationPassword.clear();
        registrationPassword.sendKeys(password);
        WebElement registrationConfirmPassword = driver.findElement(By.cssSelector(CSS_REGISTER_CONFIRM_PASSWORD_FIELD));
        registrationConfirmPassword.clear();
        registrationConfirmPassword.sendKeys(confirmPassword);
        WebElement registerName =driver.findElement(By.cssSelector(CSS_REGISTER_NAME_FIELD ));
        registerName.clear();
        registerName.sendKeys(name);
        WebElement registerSkype = driver.findElement(By.cssSelector(CSS_SKYPE_FIELD));
        registerSkype.clear();
        registerSkype.sendKeys(skype);
        WebElement registerPhone =driver.findElement(By.cssSelector(CSS_REGISTER_PHONE_FIELD));
        registerPhone.clear();
        registerPhone.sendKeys(telephone);

        WebElement registerSubmitButton =  driver.findElement(By.cssSelector(CSS_REG_SUBMIT_BUTTON));
        registerSubmitButton.click();

        WebElement popUpWelcome = driver.findElement(By.cssSelector(CSS_WELCOME_POP_UP));
        popUpWelcome.isDisplayed();
        WebElement closeWelcomePopUp = driver.findElement(By.cssSelector(CSS_BUTTON_CLOSE_WELCOME_POP_UP));
        closeWelcomePopUp.click();

    }

    public  boolean isRegistrationErrorPresent(){
        try {
            driver.findElement((By.cssSelector("p.errors")));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }


}
