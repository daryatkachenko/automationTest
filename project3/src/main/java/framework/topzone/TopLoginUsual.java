package framework.topzone;

import framework.pageobject.HomePage;
import framework.pageobject.PageObject;
import framework.utils.ControlsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 22.09.2016.
 */
public class TopLoginUsual extends PageObject {

    private static final String CSS_TOP_LOGIN_FIELD = "#top-user-form__login";
    private static final String CSS_TOP_PASSWORD_FIELD ="#top-user-form__password";
    private static  final String CSS_TOP_BTH_AUTH = "button.btn-auth-top";
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";



    public HomePage loginAsUsualWithValidCredentials(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_TOP_LOGIN_FIELD)), login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_TOP_PASSWORD_FIELD)), password);
        driver.findElement(By.cssSelector(CSS_TOP_BTH_AUTH)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));

        return new HomePage();
    }

    public void loginAs(String login,String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_TOP_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_TOP_PASSWORD_FIELD)),password);
        driver.findElement(By.cssSelector(CSS_TOP_BTH_AUTH)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
    }












}
