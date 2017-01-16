package test.topzone;

import framework.topzone.TopLoginUsual;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 15.11.2016.
 */
public class TopLoginUsualTest extends BaseTest {

    private TopLoginUsual topLoginUsual;

    @BeforeMethod
    public void before() {
        topLoginUsual = new TopLoginUsual();
    }


    @Test
    public void canLoginTopAsUsual(){
        topLoginUsual.loginAsUsualWithValidCredentials(PropertyLoader.LOGIN_TOP, PropertyLoader.PASSWORD);
    }

    @Test
    public void tryLoginWithEmptyFields(){
        topLoginUsual.loginAs("", "");
        topLoginUsual.isErrorEmptyFieldsPresent();
    }



    @Test(dataProvider = "wrongEmailAndPassword")
    public void tryLoginWithWrongEmailAndPassword(String email, String password){
        topLoginUsual.loginAs(email, password);
        topLoginUsual.isErrorWrongNameOrPasswordPresent();

    }

    @Test(dataProvider = "invalidCredentials")
    public void tryLoginWithInvalidCredentials(String email, String password) {
        topLoginUsual.loginAs(email, password);
        topLoginUsual.isErrorWrongNameOrPasswordPresent();
    }

    @DataProvider
    public Object[][] wrongEmailAndPassword(){
        return new Object[][]{
                {"dt+" + RandomStringUtils.randomNumeric(5)+"playtini.net", RandomStringUtils.randomAscii(5)},
                {"dhgh", "fdgfdgdf"}

        };
    }

    @DataProvider
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"dt+2@playtini", "kimi1979"},
                {"dt+2@playtini.ne",RandomStringUtils.randomNumeric(8)}

        };

    }



}
