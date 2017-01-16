package framework.popups;

import framework.pageobject.HomePage;
import framework.pageobject.PageObject;
import framework.utils.ControlsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 05.09.2016.
 */
public class LoginPopUp extends PageObject {

    private static final String CSS_POP_UP_AUTH = "#popup_auth";
    private static final String CSS_BTH_REG_POP_UP = "a.btn-registration-top > span";
    private static final String CSS_LINK_ENTER = "#popup_register > div.popup-body > div.popup-content.cf > div.related-popups > a";
    private static final String XPATH_LINK_ENTER = "//div[4]/div/div[2]/div/a";
    private static final String CSS_AUTH_LOGIN_FIELD = "#auth-form-login";
    private static final String CSS_AUTH_PASSWORD_FIELD = "#auth-form-password";
    private static final String CSS_AUTH_BTH_ENTER="button.btn-popup-enter";




    public LoginPopUp  open() {
        driver.findElement(By.cssSelector(CSS_BTH_REG_POP_UP)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_LINK_ENTER)));
        driver.findElement(By.xpath(XPATH_LINK_ENTER)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_AUTH)));
        return new LoginPopUp();

    }

    public HomePage loginWithValidCredentials(String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_AUTH_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox( driver.findElement(By.cssSelector(CSS_AUTH_PASSWORD_FIELD)),password);
        driver.findElement(By.cssSelector(CSS_AUTH_BTH_ENTER)).click();
        return new HomePage();
    }
    public void loginAs (String login, String password){
        ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_AUTH_LOGIN_FIELD)),login);
        ControlsHelper.fillTextBox( driver.findElement(By.cssSelector(CSS_AUTH_PASSWORD_FIELD)),password);
        driver.findElement(By.cssSelector(CSS_AUTH_BTH_ENTER)).click();

    }










}
