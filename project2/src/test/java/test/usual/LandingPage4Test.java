package test.usual;

import landingpage.LandingPage4;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;


public class LandingPage4Test extends BaseTest {
    private LandingPage4 landingPage4;


    @BeforeMethod
    public void beforeMethod() {
        landingPage4 = new LandingPage4();
    }



    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRubWithWelcomeGift(){
        landingPage4.open();
        landingPage4.clickOnButtonRegistration();
        landingPage4.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage4.welcomeGift100Bonus();

    }
    @Test(priority = 1)
    public void  canRegisterUsualWithCurrencyUsdWithWelcomeGift(){
        landingPage4.open();
        landingPage4.clickOnButtonRegistration();
        landingPage4.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage4.welcomeGift100Bonus();
    }


    @Test(priority = 2)
    public  void  tryRegisterWithEmptyFields(){
        landingPage4.open();
        landingPage4.clickOnButtonRegistration();
        landingPage4.registerAs("","");
        landingPage4.isErrorsPresent();
    }

    @Test(dataProvider = "wrongEmailAndPassword")
    public void tryRegisterWithInvalidCredentials(String email, String password){
        landingPage4.open();
        landingPage4.clickOnButtonRegistration();
        landingPage4.registerAs(email, password);
    }


    @Test(priority = 3)
    public void tryRegisterWithOutAgree(){
        landingPage4.open();
        landingPage4.clickOnButtonRegistration();
        landingPage4.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage4.isErrorsPresent();
    }



    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }
}
