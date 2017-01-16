package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by dt on 05.09.2016.
 */
public class ContactsPage extends PageObject {
    private static final String XPATH_CONTACTS_BUTTON = "//a[contains(@href, '/contacts')]";
    private static final String CSS_NAME_FIELD = "#site_message_name";
    private static final String CSS_EMAIL_FIELD = "#site_message_email";
    private static final String CSS_SUBJECT_FIELD = "#site_message_subject";
    private static final String CSS_MESSAGE_FIELD = "#site_message_content";
    private static final String CSS_SEND_CONTACT_FORM = "button.btn-send";
    private static final String CSS_RE_CAPTCHA = "div.g-recaptcha";
    private static final String CSS_FRONG_RE_CAPTCHA_MESSAGE= "div.contacts-right > h2";


//    @Step
    public void openContactsPage(){
        WebElement contactsButton = driver.findElement(By.xpath(XPATH_CONTACTS_BUTTON));
        contactsButton.click();

    }


    public boolean isReCaptchaPresent(){
        try {
            driver.findElement(By.cssSelector(CSS_RE_CAPTCHA));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
//   @Step
   public void sendContactFormWithOutReCaptcha(){
       WebElement name = driver.findElement(By.cssSelector(CSS_NAME_FIELD ));
       name.clear();
       name.sendKeys(PropertyLoader.CONTACT_FORM_NAME);
       WebElement email = driver.findElement(By.cssSelector(CSS_EMAIL_FIELD));
       email.clear();
       email.sendKeys(PropertyLoader.EMAIL);
       WebElement subject = driver.findElement(By.cssSelector(CSS_SUBJECT_FIELD));
       subject.clear();
       subject.sendKeys(PropertyLoader.CONTACT_FORM_SUBJECT);
       WebElement content = driver.findElement(By.cssSelector(CSS_MESSAGE_FIELD));
       content.clear();
       content.sendKeys(PropertyLoader.CONTACT_FORM_CONTENT);
       WebElement sendFormButton = driver.findElement(By.cssSelector(CSS_SEND_CONTACT_FORM));
       sendFormButton.click();
   }


    public boolean isMessageWrongReCaptchaPresent(){
        try {
            driver.findElement(By.cssSelector(CSS_FRONG_RE_CAPTCHA_MESSAGE));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
