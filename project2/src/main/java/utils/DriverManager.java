package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by dt on 10.10.2016.
 */
public class DriverManager {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String CHROME_DRIVER_PATH = "src/main/resources/browsers/chromedriver25.exe";


    private ThreadLocal <WebDriver> webDriver = new ThreadLocal<>();

    private final static DriverManager INSTANCE = new DriverManager();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    /**
     * Factory method to create a new WebDriver instance given to the browser. It should be created once per test suite
     *
     * @param browser: String representing the browser name (e.g. "browsers" or "firefox")
     * @return WebDriver instance
     */
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

    public WebDriver getDriver() {
        return webDriver.get();
    }

    /**
     * Helper method to set ChromeDriver location into the right system property
     */
    private void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
    }

}

