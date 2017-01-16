package test.usual;

import landingpage.LandingPage8;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 28.11.2016.
 */
public class LandingPage8Test extends BaseTest {
    private LandingPage8 landingPage8;


    @BeforeMethod
    public void beforeMethod() {
        landingPage8 = new LandingPage8();
    }

    @Test(priority = 0)
    public void canRegisterWithUsualRubWithValidCredentialsAnd100Bonus(){
        landingPage8.open();
        landingPage8.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage8.welcomeGift100Bonus();
    }

    @Test(priority = 1)
    public void canRegisterWithUsualUsdWithValidCredentialsAnd100Bonus(){
        landingPage8.open();
        landingPage8.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage8.welcomeGift100Bonus();
    }


    @Test(priority = 2)
    public void tryRegisterWithEmptyFields(){
        landingPage8.open();
        landingPage8.registerAs("", "");
        landingPage8.isEmptyPasswordFieldErrorPresent();
    }

    @Test(priority = 3)
    public void tryRegisterWithOutAgree(){
        landingPage8.open();
        landingPage8.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage8.isAgreeCheckBoxErrorPresent();

    }


    @Test(dataProvider = "inValidCredentials")
    public void tryRegisterWithInValidCredentials(String email, String password){
        landingPage8.open();
        landingPage8.registerAs(email, password);
        landingPage8.isErrorEnterValidEmailPresent();
    }

    @DataProvider
    public Object[][] inValidCredentials(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }
}
