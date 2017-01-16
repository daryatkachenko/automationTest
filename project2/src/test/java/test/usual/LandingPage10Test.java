package test.usual;

import landingpage.LandingPage10;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 10.10.2016.
 */
public class LandingPage10Test extends BaseTest {

    private LandingPage10 landingPage10;


    @BeforeMethod
    public void beforeMethod() {

        landingPage10 = new LandingPage10();
    }


    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRubAnd100Bonus(){
        landingPage10.open();
        landingPage10.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage10.welcomeGift100Bonus();
    }


    @Test(priority = 1)
    public void  canRegisterUsualWithCurrencyUsdAnd100Bonus(){
        landingPage10.open();
        landingPage10.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage10.welcomeGift100Bonus();
    }




    @Test(priority = 2)
    public  void  tryRegisterWithEmptyFields(){
        landingPage10.open();
        landingPage10.registerAsUsualRub("","");
        landingPage10.isErrorsPresent();
    }




    @Test(priority = 3)
    public void tryRegisterWithOutAgree(){
        landingPage10.open();
        landingPage10.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage10.isErrorsPresent();
    }




    @Test(dataProvider = "wrongEmailAndPassword")
    public  void  tryRegisterWithInValidCredentials(String email, String password){
        landingPage10.open();
        landingPage10.registerAsUsualRub(email, password);
        landingPage10.isErrorsPresent();
    }

    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }


}
