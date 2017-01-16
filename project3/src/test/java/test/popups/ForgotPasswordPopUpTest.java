package test.popups;

import framework.popups.ForgotPasswordPopUp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 03.11.2016.
 */
public class ForgotPasswordPopUpTest extends BaseTest {
    private ForgotPasswordPopUp forgotPasswordPopUp;

    @BeforeMethod
    public void before(){
        forgotPasswordPopUp = new ForgotPasswordPopUp();
    }

    @Test
    public void canOpenRestorePasswordPopUp(){
        forgotPasswordPopUp.open();
        forgotPasswordPopUp.isRestorePasswordOpened();
    }

    @Test
    public void canRestorePassword(){
        forgotPasswordPopUp.open();
        forgotPasswordPopUp.restorePassword(PropertyLoader.RESTORE_EMAIL);
        forgotPasswordPopUp.isRequestUpPresent();
    }


}
