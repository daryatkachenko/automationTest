package test;

import framework.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by dt on 05.09.2016.
 */
public class BaseTest {
    protected WebDriver registerPage;

    @BeforeClass
    public void beforeClass() {
        registerPage = DriverManager.getInstance().createDriver(PropertyLoader.BROWSER);
        registerPage.manage().window().maximize();
        registerPage.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    @BeforeMethod
    public void beforeMethod() {

      registerPage.get(PropertyLoader.URL);

    }


    @AfterMethod
    public void afterMethod(ITestResult result) {

        registerPage.manage().deleteAllCookies();

    }

    @AfterClass
    public void afterClass() {

        registerPage.quit();
    }
}
