package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by dt on 05.09.2016.
 */
public class CommissionPage extends PageObject {

    private static final String XPATH_BUTTON_COMMISSIONS = "//a[contains(@href, '/commissions')]";
    private static final String XPATH_PAGE_CONTENT = "div.gray-wrap > div.container.cf" ;
    private static final String XPATH_REVENUE_SHARE = "//h2";
    private static final String XPATH_DEPOSIT_SHARE = "//div[3]/div[2]/h2";
    private static final String XPATH_CPA = "//div[2]/div[2]/h2";
    private static final String XPATH_DETAILED_LINK = "//a[contains(@href, '/faq#faq2-5')]";



   public void openCommissionPage(){
       WebElement commissionPageButton = driver.findElement(By.xpath(XPATH_BUTTON_COMMISSIONS));
       commissionPageButton.click();
   }

    public void verifyCommissionsPage(){
        WebElement contentCommissionPage = driver.findElement(By.cssSelector(XPATH_PAGE_CONTENT ));
        contentCommissionPage.isDisplayed();
        WebElement contentRevenueShare = driver.findElement(By.xpath(XPATH_REVENUE_SHARE));
        contentRevenueShare.isDisplayed();
        WebElement contentDepositShare =driver.findElement(By.xpath(XPATH_DEPOSIT_SHARE));
        contentDepositShare.isDisplayed();
        WebElement contentCpa = driver.findElement(By.xpath(XPATH_CPA));
        contentCpa.isDisplayed();
    }

   public void openDetailed(){
       WebElement detailedLink = driver.findElement(By.xpath(XPATH_DETAILED_LINK));
       detailedLink.click();

   }




}
