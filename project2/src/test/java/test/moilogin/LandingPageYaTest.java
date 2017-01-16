package test.moilogin;

import landingpage.LandingPage11;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 11.11.2016.
 */
public class LandingPageYaTest extends BaseTest {
    private LandingPage11 landingPage11;



    @BeforeMethod
    public void beforeMethod() {
        landingPage11 = new LandingPage11();
    }

    @Test
    public void canOpenYandex(){
        landingPage11.open();
        landingPage11.checkSocialYa();

    }
}
