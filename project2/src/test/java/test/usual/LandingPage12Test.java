package test.usual;

import landingpage.LandingPage12;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;


public class LandingPage12Test extends BaseTest {
    private LandingPage12 landingPage12;


    @BeforeMethod
    public void beforeMethod() {
        landingPage12 = new LandingPage12();
    }

    @Test(priority = 0)
    public void canRegisterWithUsualRubWithValidCredentialsAnd100Bonus(){
        landingPage12.open();
        landingPage12.choose100Bonus();
        landingPage12.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
    }

    @Test(priority = 1)
    public void canRegisterWithUsualUsdWithValidCredentialsAnd100Bonus(){
        landingPage12.open();
        landingPage12.chooseCashBack();
        landingPage12.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
    }

    @Test(priority = 2)
    public void canRegisterWithUsualWithValidCredentialsWithOutBonus(){
        landingPage12.open();
        landingPage12.refuseGift();
        landingPage12.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
    }

    @Test(priority = 3)
    public void tryRegisterWithEmptyFields(){
        landingPage12.open();
        landingPage12.choose100Bonus();
        landingPage12.registerAs("", "");
        landingPage12.isEmptyPasswordFieldErrorPresent();
    }

    @Test(priority = 4)
    public void tryRegisterWithOutAgree(){
        landingPage12.open();
        landingPage12.chooseCashBack();
        landingPage12.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage12.isAgreeCheckBoxErrorPresent();

    }


    @Test(dataProvider = "inValidCredentials")
    public void tryRegisterWithInValidCredentials(String email, String password){
        landingPage12.open();
        landingPage12.refuseGift();
        landingPage12.registerAs(email, password);
        landingPage12.isErrorEnterValidEmailPresent();
    }

    @DataProvider
    public Object[][] inValidCredentials(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }
}
