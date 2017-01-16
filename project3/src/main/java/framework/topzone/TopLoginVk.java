package framework.topzone;

import framework.pageobject.HomePage;
import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 15.11.2016.
 */
public class TopLoginVk extends PageObject{

    private String parentWindow;
    private static final String U_LOGIN ="uLogin_window";
    private static final String CSS_VK_LOGIN_FIELD = "input[name=\"email\"]";
    private static final String CSS_VK_PASSWORD_FIELD = "input[name=\"pass\"]";
    private static final String CSS_VK_ALLOW = "#install_allow";
    private static final String XPATH_TOP_VK ="//div[4]/div[1]/div[1]/form/div/div[1]/div/div[1]";
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";



    public HomePage LoginTopVK(String login, String  password) {
        driver.findElement(By.xpath(XPATH_TOP_VK)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        driver.findElement(By.cssSelector(CSS_VK_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_VK_LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.cssSelector(CSS_VK_PASSWORD_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_VK_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.cssSelector(CSS_VK_ALLOW)).click();
        driver.switchTo().window(parentWindow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new HomePage();
    }

    public void registrationTopVk(String login, String password){
        driver.findElement(By.xpath(XPATH_TOP_VK)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        driver.findElement(By.cssSelector(CSS_VK_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_VK_LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.cssSelector(CSS_VK_PASSWORD_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_VK_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.cssSelector(CSS_VK_ALLOW)).click();
        driver.switchTo().window(parentWindow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));

    }


}
