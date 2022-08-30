package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;

public class Driver {
    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected static ThreadLocal<Browser> browserNames = new ThreadLocal<>();

    /**
     * @return
     */
    public static WebDriver getDriver() {
        return getDriver(Browser.CHROME);
    }

    public static WebDriver getDriver(Browser browser) {

        if (drivers.get() == null) {
            browserNames.set(browser);
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    drivers.set(new ChromeDriver(options));
                    drivers.get().manage().deleteAllCookies();
                    break;
            }
        }
        return drivers.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

    public static Browser getBrowser() {
        return browserNames.get();
    }

}
