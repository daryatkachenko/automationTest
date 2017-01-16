package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

/**
 * Created by dt on 10.10.2016.
 */
abstract class LandingPageObject {

    public static final String CSS_AJAX_PROGRESS = "img[src='/images/loader.gif']";


    private static final String CSS_BUTTON_SAVE_GIFT = "button.btn-save-gift";
    private static final String CSS_WELCOME_POP_UP = "#popup_welcome > div.popup-body.popups_nofooter > div.popup-header";
    private static final String CSS_POP_UP_COMPLETE_REG = "#popup_complete-registration";
    private static final String XPATH_COMPLETE_REG_CHECK_BOX_AGREE = "(//input[@name='agree'])[4]";
    private static final String CSS_COMPLETE_LOGIN_FIELD = "#complete-form-login";
    private static final String CSS_BTH_COMPLETE_REG ="button.btn-popup-complete-registration";

    private String parentWindow;
    private static final String U_LOGIN ="uLogin_window";


    private static final String CSS_SOCIAL_VK = "div.social-vk";
    private static final String CSS_VK_LOGIN_FIELD = "input[name=\"email\"]";
    private static final String CSS_VK_PASSWORD_FIELD = "input[name=\"pass\"]";
    private static final String CSS_VK_ALLOW = "#install_allow";


    private static final String CSS_POP_UP_REG_OK = "div.social-ok";
    private static final String CSS_OK_LOGIN_FIELD = "#field_email";
    private static final String CSS_OK_PASSWORD ="#field_password";
    private static final String CSS_OK_ALLOW = "input.button-pro.form-actions_yes";

    private static final String CSS_POP_UP_REG_FB = "div.social-fb";
    private static final String CSS_FB_LOGIN_FIELD = "#email";
    private static final String CSS_FB_PASSWORD ="#pass";
    private static final String CSS_FB_ALLOW = "#u_0_2";


    private static final String CSS_POP_UP_REG_MR = "div.social-mr";
    private static final String CSS_MR_LOGIN_FIELD = "#login";
    private static final String CSS_MR_PASSWORD ="#password";
    private static final String CSS_MR_ALLOW = "button.ui-button-main";


    private static final String CSS_POP_UP_REG_YA = "div.social-ya";
    private static final String CSS_YA_LOGIN_FIELD = "#login";
    private static final String CSS_YA_PASSWORD ="#passwd";
    private static final String XPATH_YA_ALLOW = "//button[@type='submit']";

    private static final String CSS_ERROR_LOGIN = "span.errors";
    private static final String XPATH_ERROR_EMPTY_PASSWORD = "//div[@id='popup_register-landing']/div/div[2]/form/p[2]/span";
    private static final String XPATH_ERROR_EMPTY_AGREE_CHECK_BOX = "//div[@id='popup_register-landing']/div/div[2]/form/p[4]/span";
    private static final String XPATH_ERROR_EMPTY_AGREE_CHECK_BOX_2 = "//p[4]/span";




    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25, 250);


    public HomePage welcomeGift100Bonus(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_WELCOME_POP_UP)));
        driver.findElement(By.cssSelector(CSS_BUTTON_SAVE_GIFT)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        return new HomePage();
    }


    public void isErrorRegisterWithOutAgreePresentPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ERROR_EMPTY_AGREE_CHECK_BOX)));
        driver.findElement(By.xpath(XPATH_ERROR_EMPTY_AGREE_CHECK_BOX));

    }
    public void isErrorWithOutAgreePresentPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ERROR_EMPTY_AGREE_CHECK_BOX_2)));
        driver.findElement(By.xpath(XPATH_ERROR_EMPTY_AGREE_CHECK_BOX_2));

    }


    public void isErrorRegisterWithEmptyFieldsPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_ERROR_LOGIN)));
        driver.findElement(By.cssSelector(CSS_ERROR_LOGIN));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ERROR_EMPTY_PASSWORD)));
        driver.findElement(By.xpath(XPATH_ERROR_EMPTY_PASSWORD));
    }




    public void completeSocialRegistration(String completeRegEmail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_POP_UP_COMPLETE_REG )));
        driver.findElement(By.xpath(XPATH_COMPLETE_REG_CHECK_BOX_AGREE)).click();
        driver.findElement(By.cssSelector(CSS_COMPLETE_LOGIN_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_COMPLETE_LOGIN_FIELD)).sendKeys(completeRegEmail);
        driver.findElement(By.cssSelector(CSS_BTH_COMPLETE_REG)).click();
    }

    public void isErrorEnterValidEmailPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_ERROR_LOGIN)));
        driver.findElement(By.cssSelector(CSS_ERROR_LOGIN));
    }



    public void checkSocialVk(){
        driver.findElement(By.cssSelector(CSS_SOCIAL_VK)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_VK_LOGIN_FIELD)));

    }

    public void checkSocialFb(){
        driver.findElement(By.cssSelector(CSS_POP_UP_REG_FB)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_FB_LOGIN_FIELD)));

    }

    public void checkSocialMailRu(){
        driver.findElement(By.cssSelector(CSS_POP_UP_REG_MR)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_MR_LOGIN_FIELD)));
    }


    public void checkSocialOk(){
        driver.findElement(By.cssSelector(CSS_POP_UP_REG_OK)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_OK_LOGIN_FIELD)));
    }

    public void checkSocialYa(){
        driver.findElement(By.cssSelector(CSS_POP_UP_REG_YA)).click();
        parentWindow = driver.getWindowHandle();
        driver.switchTo().window(U_LOGIN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_YA_LOGIN_FIELD)));
    }

}
