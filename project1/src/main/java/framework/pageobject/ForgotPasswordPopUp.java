package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by dt on 05.09.2016.
 */
public class ForgotPasswordPopUp extends PageObject {
    private static final String CSS_RESTORE_EMAIL_LINK = "div.auth-forgot > a";
    private static final String CSS_RESTORE_EMAIL_FIELD = "#popup-restore-email";
    private static final String XPATH_RESTORE_SUBMIT_BUTTON ="(//button[@type='submit'])[3]";

//@Step
    public void restorePassword(String email) {
        WebElement loginButton = driver.findElement(By.cssSelector(LoginPopUp.CSS_LOGIN_BUTTON));
        loginButton.click();
        WebElement forgotLink = driver.findElement(By.cssSelector(CSS_RESTORE_EMAIL_LINK));
        forgotLink.click();
        WebElement forgotEmailField =  driver.findElement(By.cssSelector(CSS_RESTORE_EMAIL_FIELD));
        forgotEmailField.clear();
        forgotEmailField.sendKeys(PropertyLoader.FORGOT_EMAIL);
        WebElement restorePasswordButton =   driver.findElement(By.xpath(XPATH_RESTORE_SUBMIT_BUTTON));
        restorePasswordButton.click();


    }
//@Step
    public void tryRestorePassword(String email){
        WebElement loginButton = driver.findElement(By.cssSelector(LoginPopUp.CSS_LOGIN_BUTTON));
        loginButton.click();
        WebElement forgotLink = driver.findElement(By.cssSelector(CSS_RESTORE_EMAIL_LINK));
        forgotLink.click();
        WebElement forgotEmailField =  driver.findElement(By.cssSelector(CSS_RESTORE_EMAIL_FIELD));
        forgotEmailField.clear();
        forgotEmailField.sendKeys(PropertyLoader.INVALID_FORGOT_EMAIL);
        WebElement restorePasswordButton =   driver.findElement(By.xpath(XPATH_RESTORE_SUBMIT_BUTTON));
        restorePasswordButton.click();
    }

    public boolean isRestorePasswordPagePresent(){
        try {
            driver.getCurrentUrl();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

}
