package test.usual;

import landingpage.LandingPage11;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 10.10.2016.
 */
public class LandingPage11Test extends BaseTest {
    private LandingPage11 landingPage11;


    @BeforeMethod
    public void beforeMethod() {
        landingPage11 = new LandingPage11();
    }


    @Test(priority = 0)
    public void canChooseBonusAndRegisterRub(){
        landingPage11.open();
        landingPage11.clickOnRightBonus();
        landingPage11.registerAsUsualRub("dt+"+RandomStringUtils.randomNumeric(6)+"@playtini.net", PropertyLoader.PASSWORD);

    }

    @Test(priority = 1)
    public void canChooseBonusAndRegisterUsd(){
        landingPage11.open();
        landingPage11.clickOnLeftCashBack();
        landingPage11.registerAsUsualRub("dt+"+RandomStringUtils.randomNumeric(7)+"@playtini.net", PropertyLoader.PASSWORD);
    }

    @Test(priority = 2)
    public void canChooseBonusAfterRegisterUsd(){
        landingPage11.open();
        landingPage11.registerAsUsualRub("dt+"+RandomStringUtils.randomNumeric(7)+"@playtini.net", PropertyLoader.PASSWORD);
        landingPage11.welcomeGift100Bonus();
    }

    @Test(priority = 3)
    public  void  tryRegisterWithEmptyFields(){
        landingPage11.open();
        landingPage11.registerAsUsualRub("","");
        landingPage11.isErrorsPresent();
    }


    @Test(priority = 4)
    public void tryRegisterWithOutAgree(){
        landingPage11.open();
        landingPage11.registerWithOutAgree("dt+"+RandomStringUtils.randomNumeric(5)+"@playtini.net",PropertyLoader.PASSWORD);
        landingPage11.isErrorsPresent();
    }


    @Test(dataProvider = "wrongEmailAndPassword")
    public  void  tryRegisterWithInValidCredentials(String email, String password){
        landingPage11.open();
        landingPage11.registerAsUsualRub(email, password);
        landingPage11.isErrorsPresent();
    }

    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6)+ "@", RandomStringUtils.randomNumeric(6)}

        };
    }

}
