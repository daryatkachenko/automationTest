package test;

import framework.utils.DriverManager;
import framework.pageobject.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by dt on 05.09.2016.
 */
public class BaseTest {
    protected HomePage homePage;

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getInstance().createDriver(PropertyLoader.BROWSER);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod() {

        driver.get(PropertyLoader.URL);

    }


    @AfterMethod
    public void afterMethod() {

        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
