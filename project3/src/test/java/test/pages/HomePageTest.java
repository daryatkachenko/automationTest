package test.pages;


import framework.notifications.HundredBonusNotification;
import framework.pageobject.HomePage;
import framework.popups.RegistrationPopUp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

import java.lang.reflect.Method;


public class HomePageTest extends BaseTest {
   private HomePage homePage;
    private HundredBonusNotification bonusNotification;

    @BeforeMethod
    public void beforeBaseMethod(Method method) {
        RegistrationPopUp registrationPopUp = new RegistrationPopUp();
        registrationPopUp.open();
        registrationPopUp.registrationAsUsualRub(PropertyLoader.getRegisterEmail(),PropertyLoader.PASSWORD);
        registrationPopUp.welcomeGift();
    }


     @Test
    public void checkHomePage(){
         homePage = new HomePage();
         homePage.isLogoPresent();
         homePage.isUserTopZonePresent();

     }

    @Test
    public void checkNotification100BonusAfterRegistration(){
        bonusNotification = new HundredBonusNotification();
        bonusNotification.clickOnButtonCollect();
        bonusNotification.checkIs100BonusPresent();

    }

    @Test
    public void checkNotification100BonusAbsentAfterClickOnButtonCollect(){
        bonusNotification = new HundredBonusNotification();
        bonusNotification.clickCollectAndClosePopUp();
        registerPage.navigate().refresh();
        bonusNotification.checkIs100BonusNotificationAbsent();
    }







}
