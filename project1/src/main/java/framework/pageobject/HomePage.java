package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 05.09.2016.
 */
public class HomePage extends PageObject {

 private static final String CSS_PROFILE="span > a";


    public HomePage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_PROFILE)));

    }




     }



