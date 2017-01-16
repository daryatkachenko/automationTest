package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends LandingPageObject{
    private static final String CSS_PROFILE ="a.profile";
    private static final String CSS_LOGO="a.logo";


    public HomePage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_LOGO)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_PROFILE)));
    }




}
