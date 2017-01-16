package test.popups;

import framework.popups.RegistrationPopUp;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 05.09.2016.
 */
public class RegisterPopUpTest extends BaseTest {
    private RegistrationPopUp registrationPopUp;



    @BeforeMethod
    public void before() {
        registrationPopUp = new RegistrationPopUp();

    }

    @Test
    public void canRegisterWithValidCredentialsUsualRub() {
        registrationPopUp.open();
        registrationPopUp.registrationAsUsualRub(PropertyLoader.getRegisterEmail(), PropertyLoader.PASSWORD);
        registrationPopUp.welcomeGift();
    }

    @Test
    public void canRegisterWithValidCredentialsUsualUsd() {
        registrationPopUp.open();
        registrationPopUp.registrationAsUsualUsd(PropertyLoader.getRegisterEmail(), PropertyLoader.PASSWORD);
        registrationPopUp.welcomeGift();
    }

    @Test
    public void tryRegisterWithEmptyFields(){
        registrationPopUp.open();
        registrationPopUp.registrationAs("", "");
        registrationPopUp.isEmptyFieldsErrorPresent();
    }

    @Test
    public void tryRegisterWithoutAgree(){
        registrationPopUp.open();
        registrationPopUp.registrationWithOutAgree(PropertyLoader.getRegisterEmail(), PropertyLoader.PASSWORD);
        registrationPopUp.isErrorRegisterWithoutAgreePresent();
    }


    @Test(dataProvider = "wrongEmailAndPassword")
    public void tryRegisterWithWrongEmailAndPassword(String email, String password){
        registrationPopUp.open();
        registrationPopUp.registrationAs(email, password);
        registrationPopUp.isErrorEnterRealEmailPresent();
    }


    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5), RandomStringUtils.randomAscii(5)},
                {"dhgh", "fdgfdgdf"}

        };
    }





}










