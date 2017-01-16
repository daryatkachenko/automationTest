package test.pages;

import framework.pageobject.VipPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;



public class VipPageTest extends BaseTest {
   private VipPage vipPage;


    @BeforeMethod
    public void before() {
        vipPage = new VipPage();
    }

    @Test
    public void openPrivacyVipPage(){
        vipPage.open();
        vipPage.checkTitle();
    }

    @Test
    public void checkIsVipPageOpened(){
        vipPage.open();
        vipPage.checkIsVipPageOpened();
        vipPage.isLogoPresent();
        vipPage.checkFooter();
    }
    }
