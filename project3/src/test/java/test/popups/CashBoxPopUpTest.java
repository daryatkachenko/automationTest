package test.popups;

import framework.popups.CashBoxPopUp;
import framework.topzone.TopLoginUsual;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

import java.lang.reflect.Method;

/**
 * Created by dt on 17.11.2016.
 */
public class CashBoxPopUpTest extends BaseTest {
    private CashBoxPopUp cashBoxPopUp;


    @BeforeMethod
    public void beforeBaseMethod(Method method) {
        TopLoginUsual topLoginUsual = new TopLoginUsual();
        topLoginUsual.loginAs(PropertyLoader.LOGIN, PropertyLoader.PASSWORD);
    }

    @Test
    public void canOpenCashBox(){
        cashBoxPopUp = new CashBoxPopUp();
        cashBoxPopUp.open();
    }

    @Test
    public void canSwitchToTabWithdrawals(){
        cashBoxPopUp = new CashBoxPopUp();
        cashBoxPopUp.open();
        cashBoxPopUp.clickOnTabWithdrawal();
    }

    @Test
    public void canSwitchToTabPaymentsHistory(){
        cashBoxPopUp = new CashBoxPopUp();
        cashBoxPopUp.open();
        cashBoxPopUp.clickOnTabPaymentsHistory();

    }

    @Test
    public void canCloseCasBoxPopUp(){
        cashBoxPopUp = new CashBoxPopUp();
        cashBoxPopUp.open();
        cashBoxPopUp.closeCashBox();
    }

    @Test
    public void canOpenCashBoxClickOnButtonRefillYourAccountFromTopUserZone(){
        cashBoxPopUp = new CashBoxPopUp();
        cashBoxPopUp.clickOnRefillYourAccountButton();
    }


    @Test
    public void canOpenCashBoxClickOnButtonRefillYourAccountFromTopUserZoneAndSwitchToTabPaymentsHistory(){
        cashBoxPopUp = new CashBoxPopUp();
        cashBoxPopUp.clickOnRefillYourAccountButton();
        cashBoxPopUp.clickOnTabPaymentsHistory();
    }




}
