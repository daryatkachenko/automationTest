package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by dt on 05.09.2016.
 */
public class LoginPopUp extends PageObject {

    public static final String CSS_LOGIN_BUTTON= "a.enter";
    public static final String CSS_LOGIN_EMAIL_FIELD = "#popup-auth-email";
    public static final String XPATH_LOGIN_PASSWORD_FIELD = "//input[@id='popup-auth-password']";
    public static  final String CSS_AUTH_BUTTON= "button.btn-auth";


    public LoginPopUp  open() {
        WebElement loginButton = driver.findElement(By.cssSelector(CSS_LOGIN_BUTTON));
        loginButton.click();
        return new LoginPopUp();
    }

    public void loginAs(String login,String password){
        WebElement loginField = driver.findElement(By.cssSelector( CSS_LOGIN_EMAIL_FIELD));
        loginField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.xpath(XPATH_LOGIN_PASSWORD_FIELD));
        passwordField.sendKeys(password);
        WebElement enterButton =  driver.findElement(By.cssSelector(CSS_AUTH_BUTTON));
        enterButton.click();
    }


    public  boolean isLoginErrorPresent(){
        try {
            driver.findElement(By.cssSelector("h2"));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }







}
