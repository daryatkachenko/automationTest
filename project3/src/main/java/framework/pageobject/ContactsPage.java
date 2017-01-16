package framework.pageobject;

import framework.utils.ControlsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 17.11.2016.
 */
public class ContactsPage extends PageObject {


    private static final String XPATH_LINK_FOOTER_CONTACTS_PAGE  = "//li[8]/a/span";
    private static final String CSS_FIELD_NAME ="#feedback-name";
    private static final String CSS_FIELD_EMAIL = "#feedback-email";
    private static final String CSS_FIELD_MESSAGE ="#feedback-message";
    private static final String CSS_BTH_SEND = "button.btn-send";
    private static final String CSS_ERROR_EMPTY_FIELD_NAME = "//form/p[2]/span";
    private static final String CSS_ERROR_EMPTY_MESSAGE_FIELD = "//p[3]/span";
    private static final String CSS_ERROR_RECAPTCHA ="//p[4]/span[2]";
    private static final String CSS_RECAPTCHA = "span.g-recaptcha";


    public ContactsPage open(){
        driver.findElement(By.xpath(XPATH_LINK_FOOTER_CONTACTS_PAGE)).click();
        return new ContactsPage();
    }

    public void sendContactForm(String name,String email,String message){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_FIELD_NAME )),name);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_FIELD_EMAIL)),email);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_FIELD_MESSAGE)),message);
        driver.findElement(By.cssSelector(CSS_BTH_SEND)).click();

    }

    public void isEmptyEmailErrorPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CSS_ERROR_EMPTY_FIELD_NAME)));
        driver.findElement(By.xpath(CSS_ERROR_EMPTY_FIELD_NAME)).isDisplayed();
    }

    public void isEmptyMessageErrorPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CSS_ERROR_EMPTY_MESSAGE_FIELD)));
        driver.findElement(By.xpath(CSS_ERROR_EMPTY_MESSAGE_FIELD)).isDisplayed();
    }

    public void isCaptchaErrorPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CSS_ERROR_RECAPTCHA )));
        driver.findElement(By.xpath(CSS_ERROR_RECAPTCHA )).isDisplayed();
    }

    public void isCaptchaPresent(){
        driver.findElement(By.cssSelector(CSS_RECAPTCHA)).isDisplayed();
    }

}