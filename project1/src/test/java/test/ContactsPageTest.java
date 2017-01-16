package test;

import framework.pageobject.ContactsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by dt on 08.09.2016.
 */
public class ContactsPageTest extends BaseTest {

    private ContactsPage contactsPage;
    private static final String URL_CONTACTS_PAGE = "deleted";


    @BeforeMethod
    public void before (){
        contactsPage =new ContactsPage();

    }

    @Test
    public void canOpenContactsPage(){
        contactsPage.openContactsPage();
        Assert.assertEquals(driver.getCurrentUrl(), URL_CONTACTS_PAGE);
    }


    @Test
    public void checkCaptchaValid (){
        contactsPage.openContactsPage();
        Assert.assertTrue(contactsPage.isReCaptchaPresent());
    }


    @Test
    public void trySendContactForm(){
        contactsPage.openContactsPage();
        contactsPage.sendContactFormWithOutReCaptcha();
        Assert.assertTrue(contactsPage.isMessageWrongReCaptchaPresent());
    }


}
