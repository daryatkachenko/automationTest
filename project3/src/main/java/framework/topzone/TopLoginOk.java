package framework.topzone;

import framework.pageobject.HomePage;
import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 15.11.2016.
 */
public class TopLoginOk extends PageObject{
    private String parentWindow;
    private static final String U_LOGIN ="uLogin_window";
    private static final String CSS_OK_LOGIN_FIELD = "#field_email";
    private static final String CSS_OK_PASSWORD ="#field_password";
    private static final String CSS_OK_ALLOW = "input.button-pro.form-actions_yes";
    private static final String XPATH_TOP_OK = "//div[4]/div[1]/div[1]/form/div/div[1]/div/div[2]";
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";


    public HomePage LoginTopOK(String login, String  password){
        driver.findElement(By.xpath(XPATH_TOP_OK)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        driver.findElement(By.cssSelector(CSS_OK_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_OK_LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.cssSelector(CSS_OK_PASSWORD)).clear();
        driver.findElement(By.cssSelector(CSS_OK_PASSWORD)).sendKeys(password);
        driver.findElement(By.cssSelector(CSS_OK_ALLOW)).click();
        driver.switchTo().window(parentWindow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new HomePage();
    }


}
