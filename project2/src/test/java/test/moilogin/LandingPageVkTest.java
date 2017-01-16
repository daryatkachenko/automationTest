package test.moilogin;

import landingpage.LandingPage1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 11.11.2016.
 */
public class LandingPageVkTest extends BaseTest {
    private LandingPage1 landingPage1;
    @BeforeMethod
    public void beforeMethod() {
        landingPage1 = new LandingPage1();


    }

    @Test
    public void canOpenVk(){
        landingPage1.open();
        landingPage1.clickOnRegistration();
        landingPage1.checkSocialVk();

    }
}
