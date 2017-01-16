package test;

import framework.pageobject.LoginPopUp;
import framework.pageobject.PromoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by dt on 17.11.2016.
 */
public class PromoPageTest extends BaseTest {
    private PromoPage promoPage;

    @BeforeMethod
    public void beforeBaseMethod(Method method) {
        LoginPopUp loginPopUp = new LoginPopUp();
        loginPopUp.open();
        loginPopUp.loginAs(PropertyLoader.LOGIN,PropertyLoader.PASSWORD);
    }

    @Test
    public void canOpenPromoPage(){
        promoPage =new PromoPage();
        promoPage.open();
    }

    @Test
    public void canClickOnAddPromoLink(){
        promoPage =new PromoPage();
        promoPage.open();
        promoPage.clickAddPromo();
    }

    @Test
    public void canAddPromoForVulkan(){
        promoPage =new PromoPage();
        promoPage.open();
        promoPage.clickAddPromo();
        promoPage.addVulkanPromo();
        promoPage.addNamePromo();
        promoPage.clickSavePromo();
    }

    @Test

    public void canAddPromoForGaminator(){
        promoPage =new PromoPage();
        promoPage.open();
        promoPage.clickAddPromo();
        promoPage.addGaminatorPromo();
        promoPage.addNamePromo();
        promoPage.clickSavePromo();
    }

}
