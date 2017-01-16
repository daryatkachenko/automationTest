package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 05.09.2016.
 */
public class HomePage extends PageObject{
    private static final String CSS_PROFILE ="a.profile";
    private static final String CSS_LOGO = "a.logo";
    public static final String CSS_TOP_USER_ZONE = "div.top-user-zone";

    public HomePage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_PROFILE)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_LOGO)));
    }


    public void isUserTopZonePresent(){
        try {
            driver.findElement(By.cssSelector(CSS_TOP_USER_ZONE));
        } catch (NullPointerException e) {
        }
    }



}
