package test.popups;

import framework.popups.LoginPopUp;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 05.09.2016.
 */
public class LoginPopUpTest extends BaseTest {
    private LoginPopUp loginPopUp;



    @BeforeMethod
    public void before() {
        loginPopUp = new LoginPopUp();

    }

    @Test
    public void canLoginAsUsual(){
        loginPopUp.open();
        loginPopUp.loginWithValidCredentials(PropertyLoader.LOGIN, PropertyLoader.PASSWORD);
    }

    @Test
    public void tryLoginWithEmptyFields(){
        loginPopUp.open();
        loginPopUp.loginAs("","");
        loginPopUp.isErrorEmptyFieldsPresent();
    }

    @Test(dataProvider = "wrongEmailAndPassword")
    public void  tryLoginWithWrongEmailAndPassword(String email, String password){
        loginPopUp.open();
        loginPopUp.loginAs(email, password);
        loginPopUp.isErrorWrongNameOrPasswordPresent();
    }

    @Test(dataProvider = "invalidCredentials")
    public void tryLoginWithInvalidCredentials(String email, String password) {
        loginPopUp.open();
        loginPopUp.loginAs(email, password);
        loginPopUp.isErrorWrongNameOrPasswordPresent();
    }



    @DataProvider
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"dt+2@playtini", "kimi1979"},
                {"dt+2@playtini.net",RandomStringUtils.randomNumeric(8)}

        };

    }



    @DataProvider

    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5)+"playtini.net", RandomStringUtils.randomAscii(5)},
                {"dhgh", "fdgfdgdf"}

        };
    }


}
