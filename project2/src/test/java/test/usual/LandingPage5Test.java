package test.usual;

import landingpage.LandingPage5;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

public class LandingPage5Test extends BaseTest {
    private LandingPage5 landingPage5;

    @BeforeMethod
    public void beforeMethod() {

        landingPage5 = new LandingPage5();
    }

    @Test(priority = 1)
    public void canClickOnButtonPlay(){
        landingPage5.open();
        landingPage5.clickOnButtonPlay();
    }

    @Test(priority = 2)
    public void canClickOnButtonRegistration(){
        landingPage5.open();
        landingPage5.clickOnButtonRegistration();
    }
    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRubAnd100Bonus(){
        landingPage5.open();
        landingPage5.clickOnButtonRegistration();
        landingPage5.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage5.welcomeGift100Bonus();
    }

    @Test(priority = 3)
    public void  canRegisterUsualWithCurrencyUsdAnd100Bonus(){
        landingPage5.open();
        landingPage5.clickOnButtonPlay();
        landingPage5.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage5.welcomeGift100Bonus();
    }


    @Test(priority = 4)
    public  void  tryRegisterWithEmptyFields(){
        landingPage5.open();
        landingPage5.clickOnButtonRegistration();
        landingPage5.registerAs("","");
        landingPage5.isErrorsPresent();
    }

    @Test(priority = 5)
    public void tryRegisterWithOutAgree(){
        landingPage5.open();
        landingPage5.clickOnButtonRegistration();
        landingPage5.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage5.isErrorsPresent();
    }



    @Test(dataProvider = "wrongEmailAndPassword")
    public  void  tryRegisterWithInValidCredentials(String email, String password){
        landingPage5.open();
        landingPage5.clickOnButtonRegistration();
        landingPage5.registerWithOutAgree(email, password);
        landingPage5.isErrorsPresent();
    }



    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }


}
