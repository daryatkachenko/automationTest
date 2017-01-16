package test.moilogin;

import landingpage.LandingPage6;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 11.11.2016.
 */
public class LandingPageMrTest extends BaseTest {
    private LandingPage6 landingPage6;



    @BeforeMethod
    public void beforeMethod() {
        landingPage6 = new LandingPage6();
    }

    @Test
    public void canOpenMailRu(){
        landingPage6.open();
        landingPage6.checkSocialMailRu();
    }
}
