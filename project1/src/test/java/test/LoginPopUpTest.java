package test;

import framework.pageobject.LoginPopUp;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPopUpTest extends BaseTest {
    private LoginPopUp loginPopUp;



    @BeforeMethod
    public void before() {
        loginPopUp = new LoginPopUp();

    }


    @Test
    public void canLoginWithValidCredentials() {
        loginPopUp.open();
        loginPopUp.loginAs(PropertyLoader.LOGIN, PropertyLoader.PASSWORD);
    }


    @Test(dataProvider = "invalidCredentials")
    public void tryLoginWithUnValidCredentials(String email, String password) {
        driver.findElement(By.cssSelector(LoginPopUp.CSS_LOGIN_BUTTON)).click();
        driver.findElement(By.cssSelector(LoginPopUp.CSS_LOGIN_EMAIL_FIELD)).sendKeys(email);
        driver.findElement(By.xpath(LoginPopUp.XPATH_LOGIN_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.cssSelector(LoginPopUp.CSS_AUTH_BUTTON)).click();
        Assert.assertTrue(loginPopUp.isLoginErrorPresent());


    }

    @DataProvider
    public Object[][] invalidCredentials() {
        return new Object[][]{
        {PropertyLoader.LOGIN, RandomStringUtils.randomAscii(5)},
        {"dhgh@playtini.net", PropertyLoader.PASSWORD}

    };
}

}
