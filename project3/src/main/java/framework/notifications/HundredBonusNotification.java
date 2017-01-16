package framework.notifications;

import framework.pageobject.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 03.11.2016.
 */
public class HundredBonusNotification extends HomePage{
    private static final String CSS_NOTIFICATION_100_BONUS = "#hundred-bonus-popup";
    private static final String CSS_BTH_COLLECT = "#btn-collect-hundred-bonus";
    private static final String XPATH_POP_UP_FIRST_BONUS = "//div[@id='popup_bonus-first']";
    private static final String CSS_CLOSE_POP_UP_FIRST_BONUS ="#popup_bonus-first > a.popup-close";
    private static final String CSS_HEADER_POP_UP_FIRST_BONUS = "p.text-header > span";
    private static final String XPATH_BTH_COLLECT ="//a[@id='btn-collect-hundred-bonus']";

    public HundredBonusNotification(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_NOTIFICATION_100_BONUS)));
    }


    public void clickOnButtonCollect(){
        driver.findElement(By.cssSelector(CSS_BTH_COLLECT)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_POP_UP_FIRST_BONUS)));
    }


    public void checkIs100BonusPresent(){
       driver.findElement(By.cssSelector(CSS_HEADER_POP_UP_FIRST_BONUS)).isDisplayed();
    }

    public void clickCollectAndClosePopUp(){
        driver.findElement(By.xpath(XPATH_BTH_COLLECT)).click(); //ще один способ как кликнуть на кнопку забрать
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_POP_UP_FIRST_BONUS)));
        driver.findElement(By.cssSelector(CSS_CLOSE_POP_UP_FIRST_BONUS)).click();

    }

    public void checkIs100BonusNotificationAbsent(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CSS_NOTIFICATION_100_BONUS)));
    }


}
