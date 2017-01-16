package framework.topzone;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 15.11.2016.
 */
public class TopRegisterFb extends PageObject {
    private String parentWindow;
    private static final String U_LOGIN ="uLogin_window";
    private static final String CSS_FB_LOGIN_FIELD = "#email";
    private static final String CSS_FB_PASSWORD ="#pass";
    private static final String CSS_FB_ALLOW = "#u_0_2";
    private static final String XPATH_TOP_FB = "//div[4]/div[1]/div[1]/form/div/div[1]/div/div[4]";
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";

    public void registrationTopFb(String login, String password){
        driver.findElement(By.xpath(XPATH_TOP_FB)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        driver.findElement(By.cssSelector(CSS_FB_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_FB_LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.cssSelector(CSS_FB_PASSWORD)).clear();
        driver.findElement(By.cssSelector(CSS_FB_PASSWORD)).sendKeys(password);
        driver.findElement(By.cssSelector(CSS_FB_ALLOW)).click();
        driver.switchTo().window(parentWindow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }
}
