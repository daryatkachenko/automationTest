package test;


import framework.pageobject.ForgotPasswordPopUp;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by dt on 07.09.2016.
 */
public class ForgotPasswordPopUpTest extends BaseTest {

    private ForgotPasswordPopUp forgotPasswordPopUp;


    @BeforeMethod
    public void before() {
        forgotPasswordPopUp = new ForgotPasswordPopUp();
    }



    @Test
    public void canRestorePassword() {
        forgotPasswordPopUp.restorePassword(PropertyLoader.FORGOT_EMAIL);
        Assert.assertTrue(forgotPasswordPopUp.isRestorePasswordPagePresent());


    }


    @Test
    public void tryRestorePassword() {
        forgotPasswordPopUp.tryRestorePassword(PropertyLoader.INVALID_FORGOT_EMAIL);
    }
}




