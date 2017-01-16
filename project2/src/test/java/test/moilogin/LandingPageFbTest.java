package test.moilogin;

import landingpage.LandingPage5;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

public class LandingPageFbTest extends BaseTest {
    private LandingPage5 landingPage5;

    @BeforeMethod
    public void beforeMethod() {

        landingPage5 = new LandingPage5();
    }

    @Test
    public void canOpenFb(){
        landingPage5.open();
        landingPage5.clickOnButtonPlay();
        landingPage5.checkSocialFb();
    }


}


