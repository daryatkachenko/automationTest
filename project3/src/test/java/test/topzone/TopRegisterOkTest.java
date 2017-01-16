package test.topzone;

import framework.topzone.TopRegisterOk;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 15.11.2016.
 */
public class TopRegisterOkTest extends BaseTest {
    private TopRegisterOk topRegisterOk;

    @BeforeMethod
    public void before() {
        topRegisterOk =new TopRegisterOk();
    }

    @Test
    public void canRegisterAsSocialOk(){
        topRegisterOk.registrationSocialAsOk(PropertyLoader.SOCIAL_REG_PHONE,PropertyLoader.SOCIAL_REG_PASSWORD);
    }

}
