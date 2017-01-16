package test.pages;

import framework.pageobject.ContactsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 17.11.2016.
 */
public class ContactsPageTest extends BaseTest {
    ContactsPage contactsPage;

   @BeforeMethod
    public void before(){
    contactsPage =new ContactsPage();
   }

    @Test
    public void canOpenContactsPage(){
        contactsPage.open();
        Assert.assertEquals(registerPage.getCurrentUrl(), PropertyLoader.URL_CONTACTS);
    }



    @Test
    public void trySendEmptyFormWithOutCaptcha(){
        contactsPage.open();
        contactsPage.sendContactForm("","","");
        contactsPage.isCaptchaErrorPresent();
        contactsPage.isEmptyEmailErrorPresent();
        contactsPage.isEmptyMessageErrorPresent();
    }

    @Test
    public void isCaptchaPresentOnThePage(){
        contactsPage.open();
        contactsPage.isCaptchaPresent();

    }



}
