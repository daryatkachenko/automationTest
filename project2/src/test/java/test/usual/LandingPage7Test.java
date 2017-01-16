package test.usual;

import landingpage.LandingPage7;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 28.11.2016.
 */
public class LandingPage7Test extends BaseTest {
    private LandingPage7 landingPage7;


    @BeforeMethod
    public void beforeMethod() {
        landingPage7 = new LandingPage7();
    }

    @Test(priority = 0)
    public void canRegisterWithUsualWithValidCredentialsAnd100Bonus(){
        landingPage7.open();
        landingPage7.choose100Bonus();
        landingPage7.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
    }

    @Test(priority = 1)
    public void canRegisterWithUsualWithValidCredentialsAndCashBack(){
        landingPage7.open();
        landingPage7.chooseCashBack();
        landingPage7.registerAsUsualUsd(PropertyLoader.generateRegisterEmail2(), PropertyLoader.PASSWORD);
    }

    @Test(priority = 2)
    public void canRegisterWithUsualWithValidCredentialsWithOutBonus(){
        landingPage7.open();
        landingPage7.refuseGift();
        landingPage7.registerAsUsualRub(PropertyLoader.generateRegisterEmail(), PropertyLoader.PASSWORD);
    }

    @Test(priority = 3)
    public void tryRegisterWithEmptyFields(){
        landingPage7.open();
        landingPage7.choose100Bonus();
        landingPage7.registerAs("", "");
        landingPage7.isEmptyPasswordFieldErrorPresent();
    }

    @Test(priority = 4)
    public void tryRegisterWithOutAgree(){
        landingPage7.open();
        landingPage7.chooseCashBack();
        landingPage7.registerWithOutAgree(PropertyLoader.generateRegisterEmail2(),PropertyLoader.PASSWORD);
        landingPage7.isAgreeCheckBoxErrorPresent();

    }



    @Test(dataProvider = "inValidCredentials")
    public void tryRegisterWithInValidCredentials(String email, String password){
        landingPage7.open();
        landingPage7.refuseGift();
        landingPage7.registerAs(email, password);
        landingPage7.isErrorEnterValidEmailPresent();
    }

    @DataProvider
    public Object[][] inValidCredentials(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomNumeric(6)}

        };
    }

}
