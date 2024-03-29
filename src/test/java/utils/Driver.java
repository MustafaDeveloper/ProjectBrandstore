package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected static ThreadLocal<Browser> browserNames = new ThreadLocal<>();

    /**
     * Threadlocal is used instead of singleton driver so that the driver can be used in parallel tests.
     * *
     */
    public static WebDriver getDriver() {
        return getDriver(Browser.CHROME);
    }

    public static WebDriver getDriver(Browser browser) {

        if (drivers.get() == null) {
            browserNames.set(browser);
            switch (browser) {
                case FIREFOX:
                    drivers.set(new FirefoxDriver());
                    break;
                case EDGE:

                    drivers.set(new EdgeDriver());
                    break;
                default:
                   // System.setProperty("webdriver.chrome.driver", "/C:/Users/Mustafa/Downloads/chromedriver_win32");

                    drivers.set(new ChromeDriver());
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
