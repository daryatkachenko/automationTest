package framework.popups;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;


public class ForgotPasswordPopUp extends PageObject {


    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";

    private static final String CSS_LINK_FOGERT_PASSWORD = "p.restore-password > a";
    private static final String CSS_POP_UP_FOGORT_PASSWORD = "#popup_restore-password ";
    private static final String CSS_FIELD_RESTORE_PASSWORD = "#restore-form-login";
    private static final String XPATH_FIELD_RESTORE_PASSWORD = "(//input[@id='restore-form-login'])[2]";
    private static final String CSS_BTH_RESTORE = "button.btn-popup-restore";
    private static final String CSS_POP_UP_ALERT = "#popup_alert";


    public ForgotPasswordPopUp open(){
        driver.findElement(By.cssSelector(CSS_LINK_FOGERT_PASSWORD)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_FOGORT_PASSWORD)));
        return new ForgotPasswordPopUp();
    }


    public void restorePassword(String restorePasswordEmail){
        driver.findElement(By.cssSelector(CSS_FIELD_RESTORE_PASSWORD)).clear();
        driver.findElement(By.cssSelector(CSS_FIELD_RESTORE_PASSWORD)).sendKeys(restorePasswordEmail);
        driver.findElement(By.cssSelector(CSS_BTH_RESTORE)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }



    public boolean isRequestUpPresent(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_ALERT)));
            driver.findElement(By.cssSelector(CSS_POP_UP_ALERT));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean  isRestorePasswordOpened(){
        try {
            driver.findElement(By.cssSelector(CSS_POP_UP_FOGORT_PASSWORD));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
