package framework.pageobject;


import framework.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by dt on 05.09.2016.
 */
public abstract class PageObject {

    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25, 300);

}
