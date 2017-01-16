package framework.popups;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 17.11.2016.
 */
public class CashBoxPopUp extends PageObject {

    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";
    private static final String CSS_BTH_CASH_BOX = "a.cashbox";
    private static final String CSS_POP_UP_CASH_BOX_HEADER = " #popup_cashbox-deposit > div.popup-body > div.popup-header";
    private static final String CSS_POP_UP_CASH_BOX = "#popup_cashbox-deposit";
    private static final String CSS_BTN_WITHDRAWAL = "a.profile-switch__tab.tab-withdrawal > span";
    private static final String CSS_POP_UP_WITHDRAWAL = "#popup_cashbox-withdrawal";
    private static final String CSS_BTH_PAYMENTS_HISTORY = "a.profile-switch__tab.tab-history > span";
    private static final String CSS_POP_UP_PAYMENTS_HISTORY = "#popup_payments-history";
    private static final String CSS_EMPTY_PAYMENTS_HISTORY = "td.payments-history__cell-empty > a";
    private static final String CSS_BTN_CLOSE_CASH_BOX = "#popup_cashbox-deposit > a.popup-close";
    private static final String CSS_BTN_DEPOSIT_TOP_USER_ZONE = "a.btn-recharge-top > span";



    public CashBoxPopUp open(){
        driver.findElement(By.cssSelector(CSS_BTH_CASH_BOX )).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_CASH_BOX_HEADER)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new CashBoxPopUp();
    }

    public void clickOnTabWithdrawal(){
        driver.findElement(By.cssSelector(CSS_BTN_WITHDRAWAL)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_WITHDRAWAL)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        driver.findElement(By.cssSelector(CSS_POP_UP_WITHDRAWAL)).isDisplayed();
    }

    public void clickOnTabPaymentsHistory(){
        driver.findElement(By.cssSelector(CSS_BTH_PAYMENTS_HISTORY)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_PAYMENTS_HISTORY)));
        driver.findElement(By.cssSelector(CSS_POP_UP_PAYMENTS_HISTORY)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_EMPTY_PAYMENTS_HISTORY )));
        driver.findElement(By.cssSelector(CSS_EMPTY_PAYMENTS_HISTORY )).isDisplayed();

    }

    public void closeCashBox(){
        driver.findElement(By.cssSelector(CSS_BTN_CLOSE_CASH_BOX )).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_POP_UP_CASH_BOX)));
    }

    public   CashBoxPopUp clickOnRefillYourAccountButton(){
        driver.findElement(By.cssSelector(CSS_BTN_DEPOSIT_TOP_USER_ZONE)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_CASH_BOX_HEADER)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new CashBoxPopUp();
    }


}
