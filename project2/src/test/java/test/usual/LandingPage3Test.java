package test.usual;

import landingpage.LandingPage3;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;


public class LandingPage3Test extends BaseTest {

    private LandingPage3 landingPage3;


    @BeforeMethod
    public void beforeMethod() {
        landingPage3 = new LandingPage3();
    }


    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRubWithWelcomeGift() {
        landingPage3.open();
        landingPage3.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage3.welcomeGift100Bonus();

    }

    @Test(priority = 1)
    public void canRegisterUsualWithCurrencyUsdWithWelcomeGift() {
        landingPage3.open();
        landingPage3.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage3.welcomeGift100Bonus();
    }


    @Test(priority = 2)
    public void tryRegisterWithEmptyFields() {
        landingPage3.open();
        landingPage3.registerAs("","");
        //поставить проверку
    }


    @Test(priority = 3)
    public void tryRegisterWithOutAgree() {
        landingPage3.open();
        landingPage3.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage3.isErrorWithOutAgreePresentPresent();
    }




    @Test(dataProvider = "wrongEmailAndPassword")
    public void tryRegisterWitInvalidCredentials(String email,String password){
        landingPage3.open();
        landingPage3.registerAs(email, password);
        landingPage3.isErrorEnterValidEmailPresent();

    }



    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }


}
