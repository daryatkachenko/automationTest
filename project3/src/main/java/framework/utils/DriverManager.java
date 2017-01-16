package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by dt on 05.09.2016.
 */
public class DriverManager {
    private static final String CHROME ="chrome";
    private  static final String CHROME_DRIVER_PATH = "src\\main\\resources\\Browsers\\chromedriver25.exe";
    private static final String FIREFOX = "firefox";


    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private final static DriverManager INSTANCE = new DriverManager();
    private DriverManager(){

    }
    public static DriverManager getInstance(){
        return INSTANCE;
    }


    public WebDriver createDriver(String browser) {
        if (CHROME.equalsIgnoreCase(browser)) {
            setChromeDriver();
            webDriver.set(new ChromeDriver());

        } else if (FIREFOX.equalsIgnoreCase(browser)) {
            webDriver.set(new FirefoxDriver());

        } else {
            throw new UnsupportedOperationException(String.format("Browser %1$s is not supported!", browser));
        }

        return webDriver.get();
    }


    private void setChromeDriver() {

        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
    }



    public WebDriver getDriver() {
        return webDriver.get();
    }
}
