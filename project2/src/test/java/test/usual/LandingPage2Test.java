package test.usual;

import landingpage.LandingPage2;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;


public class LandingPage2Test extends BaseTest {
    private LandingPage2 landingPage2;



    @BeforeMethod
    public void beforeMethod() {

        landingPage2 = new LandingPage2();
    }

    @Test
    public void canOpenLandingPage2(){
        landingPage2.open();
    }


    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRubWithWelcomeGift(){
        landingPage2.open();
        landingPage2.clickOnButtonRegistration();
        landingPage2.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage2.welcomeGift100Bonus();

    }

    @Test(priority = 1)
    public void  canRegisterUsualWithCurrencyUsdWithWelcomeGift(){
        landingPage2.open();
        landingPage2.clickOnButtonRegistration();
        landingPage2.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage2.welcomeGift100Bonus();
    }


    @Test(priority = 2)
    public  void  tryRegisterWithEmptyFields(){
        landingPage2.open();
        landingPage2.clickOnButtonRegistration();
        landingPage2.registerAs("","");
        landingPage2.isErrorRegisterWithEmptyFieldsPresent();
    }


    @Test(priority = 3)
    public void tryRegisterWithOutAgree(){
        landingPage2.open();
        landingPage2.clickOnButtonRegistration();
        landingPage2.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage2.isErrorRegisterWithOutAgreePresentPresent();

    }


    @Test(dataProvider = "wrongEmailAndPassword")
    public void tryRegisterWitInvalidCredentials(String email,String password){
        landingPage2.open();
        landingPage2.clickOnButtonRegistration();
        landingPage2.registerAs(email, password);
        landingPage2.isErrorEnterValidEmailPresent();

    }

    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }

}
