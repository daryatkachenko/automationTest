package test.pages;

import framework.pageobject.BonusPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 01.12.2016.
 */
public class BonusPageTest extends BaseTest {
    private BonusPage bonusPage;

    @BeforeMethod
    public void before(){
        bonusPage = new BonusPage();
    }
    @Test
    public void openBonusPage(){
        bonusPage.open();
        bonusPage.checkTitle();
    }

    @Test
    public void checkIsBonusPageOpened(){
        bonusPage.open();
        bonusPage.checkIsBonusPageOpened();
        bonusPage.isLogoPresent();
        bonusPage.checkFooter();
    }

}
