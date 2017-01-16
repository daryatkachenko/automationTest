package test.usual;

import landingpage.LandingPage1;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;


public class LandingPage1Test extends BaseTest {
private LandingPage1 landingPage1;


    @BeforeMethod
    public void beforeMethod() {

        landingPage1 = new LandingPage1();
    }



    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRubWithWelcomeGift(){
        landingPage1.open();
        landingPage1.clickOnRegistration();
        landingPage1.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage1.welcomeGift100Bonus();

    }
    @Test(priority = 1)
    public void  canRegisterUsualWithCurrencyUsdWithWelcomeGift(){
        landingPage1.open();
        landingPage1.clickOnRegistration();
        landingPage1.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage1.welcomeGift100Bonus();
    }



    @Test(priority = 2)
    public  void  tryRegisterWithEmptyFields(){
        landingPage1.open();
        landingPage1.clickOnRegistration();
        landingPage1.registerAs("","");
        landingPage1.isErrorRegisterWithEmptyFieldsPresent();
    }


    @Test(priority = 3)
    public void tryRegisterWithOutAgree(){
        landingPage1.open();
        landingPage1.clickOnRegistration();
        landingPage1.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage1.isErrorRegisterWithOutAgreePresentPresent();
    }


    @Test(dataProvider = "wrongEmailAndPassword")
    public  void  tryRegisterWithInvalidCredentials(String email, String password){
        landingPage1.open();
        landingPage1.clickOnRegistration();
        landingPage1.registerAs(email, password);
    }



    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {"dhgh", "fdgfdgdf"}

        };
    }


}
