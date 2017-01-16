package test.topzone;

import framework.topzone.TopLoginFb;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 15.11.2016.
 */
public class TopLoginFbTest extends BaseTest {
   private TopLoginFb topLoginFb;

    @BeforeMethod
    public void before() {
        topLoginFb =new TopLoginFb();
    }

   @Test
    public void canLoginAsFaceBook(){
       topLoginFb.loginTopFB(PropertyLoader.SOCIAL_LOGIN,PropertyLoader.SOCIAL_PASSWORD);
   }

}
