package test.moilogin;

import landingpage.LandingPage2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 11.11.2016.
 */
public class LandingPageOkTest extends BaseTest {
  private   LandingPage2 landingPage2;

    @BeforeMethod
    public void beforeMethod() {

        landingPage2 = new LandingPage2();
    }


    @Test
    public void canOpenOk(){
        landingPage2.open();
        landingPage2.clickOnButtonRegistration();
        landingPage2.checkSocialOk();
    }
}
