package test.pages;

import framework.pageobject.LotteryPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;


public class LotteryPageTest extends BaseTest {
    private LotteryPage lotteryPage;

    @BeforeMethod
    public void before() {
        lotteryPage = new LotteryPage();
    }

    @Test
    public void canOpenPage(){
        lotteryPage.open();
        lotteryPage.isLogoPresent();
        lotteryPage.checkFooter();
    }

    @Test
    public void verifyPage(){
        lotteryPage.open();
        lotteryPage.isLotteryPageBannerPresent();
        lotteryPage.checkTitle();

    }
}
