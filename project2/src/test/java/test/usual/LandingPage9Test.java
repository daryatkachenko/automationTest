package test.usual;

import landingpage.LandingPage9;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 10.10.2016.
 */
public class LandingPage9Test extends BaseTest {
    private LandingPage9 landingPage9;



    @BeforeMethod
    public void beforeMethod() {
        landingPage9 = new LandingPage9();
    }

    @Test
    public void canOpenLandingPage9(){
        landingPage9.open();
    }



    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRub(){
        landingPage9.open();
        landingPage9.registerAsUsualRub(PropertyLoader.generateRegisterEmail(),PropertyLoader.PASSWORD);
        landingPage9.welcomeGift100Bonus();
    }


    @Test(priority = 1)
    public void  canRegisterUsualWithCurrencyUsdAnd100Bonus(){
        landingPage9.open();
        landingPage9.registerAsUsualUsd100Bonus(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage9.welcomeGift100Bonus();
    }


    @Test(priority = 2)
    public  void  tryRegisterWithEmptyFields(){
        landingPage9.open();
        landingPage9.registerAs("","");
        landingPage9.isErrorsPresent();
    }

    @Test(priority = 3)
    public void tryRegisterWithOutAgree(){
        landingPage9.open();
        landingPage9.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage9.isErrorsPresent();
    }


    @Test(dataProvider = "wrongEmailAndPassword")
    public  void  tryRegisterWithInValidCredentials(String email, String password){
        landingPage9.open();
        landingPage9.registerAs(email,password);
        landingPage9.isErrorsPresent();
    }

    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }

}
