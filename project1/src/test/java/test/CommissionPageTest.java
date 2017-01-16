package test;

import framework.pageobject.CommissionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by dt on 07.09.2016.
 */
public class CommissionPageTest extends BaseTest {

    private CommissionPage commissionPage;
    private static final String URL_COMMISSIONS_PAGE = "deleted";
    private static final String URL_DETAILED = "deleted ";




    @BeforeMethod
    public void before(){
        commissionPage = new CommissionPage();
    }


    @Test
    public void canOpenCommissionsPage(){
        commissionPage.openCommissionPage();
        Assert.assertEquals(URL_COMMISSIONS_PAGE, driver.getCurrentUrl());
        commissionPage.verifyCommissionsPage();
    }

    @Test
    public void canOpenDetailed(){
        commissionPage.openCommissionPage();
        commissionPage.openDetailed();
        Assert.assertEquals(URL_DETAILED,driver.getCurrentUrl());

    }
}
