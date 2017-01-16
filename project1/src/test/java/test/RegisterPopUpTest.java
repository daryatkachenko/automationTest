package test;

import framework.pageobject.RegistrationPopUp;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by dt on 05.09.2016.
 */
public class RegisterPopUpTest extends BaseTest {
    private RegistrationPopUp registrationPopUp;

    @BeforeMethod
    public void before() {
        registrationPopUp = new RegistrationPopUp();

    }

    @Test
    public void canRegisterWithValidCredentials() {
        registrationPopUp.open();
        registrationPopUp.registrationAs(PropertyLoader.EMAIL, PropertyLoader.PASSWORD, PropertyLoader.CONFIRM_PASSWORD, PropertyLoader.NAME, PropertyLoader.SKYPE, PropertyLoader.TELEPHONE);

    }

    @Test(dataProvider ="invalidCredentialsRegistration")
    public void tryRegisterWithInValidCredentials(String email, String password, String confirmPassword, String name, String skype, String phone) {
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_REGISTER_BUTTON)).click();
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_REGISTER_EMAIL_FIELD)).sendKeys(email);
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_REGISTER_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_REGISTER_CONFIRM_PASSWORD_FIELD)).sendKeys(confirmPassword);
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_REGISTER_NAME_FIELD)).sendKeys(name);
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_SKYPE_FIELD)).sendKeys(skype);
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_REGISTER_PHONE_FIELD)).sendKeys(phone);
        driver.findElement(By.cssSelector(RegistrationPopUp.CSS_REG_SUBMIT_BUTTON)).click();
        Assert.assertTrue(registrationPopUp.isRegistrationErrorPresent());


    }

    @DataProvider
    public Object[][] invalidCredentialsRegistration() {
        return new Object[][]{
                {"dt@play", PropertyLoader.PASSWORD, PropertyLoader.CONFIRM_PASSWORD, PropertyLoader.NAME, PropertyLoader.SKYPE, PropertyLoader.TELEPHONE},
                {PropertyLoader.EMAIL, "dfgfdgfd", PropertyLoader.CONFIRM_PASSWORD, PropertyLoader.NAME, PropertyLoader.SKYPE, PropertyLoader.TELEPHONE},
                {PropertyLoader.EMAIL, PropertyLoader.PASSWORD, "fdgfgfdgfdg", PropertyLoader.NAME, PropertyLoader.SKYPE, PropertyLoader.TELEPHONE}
        };

    }
}
