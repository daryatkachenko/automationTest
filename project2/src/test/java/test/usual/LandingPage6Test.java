package test.usual;

import landingpage.LandingPage6;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 10.10.2016.
 */
public class LandingPage6Test extends BaseTest {

    private LandingPage6 landingPage6;



    @BeforeMethod
    public void beforeMethod() {
        landingPage6 = new LandingPage6();
    }

    @Test
    public void canOpenLandingPage6(){
        landingPage6.open();
    }



    @Test(priority = 0)
    public void canRegisterUsualWithCurrencyRubAnd100Bonus(){
        landingPage6.open();
        landingPage6.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
        landingPage6.welcomeGift100Bonus();
    }

    @Test(priority = 1)
    public void  canRegisterUsualWithCurrencyUsdAnd100Bonus(){
        landingPage6.open();
        landingPage6.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
        landingPage6.welcomeGift100Bonus();
    }


    @Test(priority = 2)
    public  void  tryRegisterWithEmptyFields(){
        landingPage6.open();
        landingPage6.registerAs("","");
        landingPage6.isErrorsPresent();
    }


    @Test(priority = 3)
    public void tryRegisterWithOutAgree(){
        landingPage6.open();
        landingPage6.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage6.isErrorsPresent();
    }



    @Test(dataProvider = "wrongEmailAndPassword")
    public  void  tryRegisterWithInValidCredentials(String email,String password){
        landingPage6.open();
        landingPage6.registerAs(email, password);
        landingPage6.isErrorsPresent();
    }

    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }

}
