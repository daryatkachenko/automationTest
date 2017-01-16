package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.DriverManager;

import java.util.concurrent.TimeUnit;

/**
 * Created by dt on 10.10.2016.
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getInstance().createDriver(PropertyLoader.BROWSER);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
