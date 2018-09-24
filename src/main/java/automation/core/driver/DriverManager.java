package automation.core.driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import automation.core.reporting.Logger;
import automation.core.runner.BrowserType;

public class DriverManager {

    private static final Logger LOGGER = new Logger(DriverManager.class);

    private static volatile DriverManager instance;

    private static BrowserType browserType;

    private static List<WebDriver> createdDrivers = new ArrayList<>();

    private ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static DriverManager getInstance() {
        DriverManager localInstance = instance;
        if (localInstance == null) {
            synchronized (DriverManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    LOGGER.info("Create driver manager instance.");
                    instance = localInstance = new DriverManager();
                }
            }
        }
        return localInstance;
    }

    private DriverManager() {
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            synchronized (DriverManager.class) {
                WebDriver driver = DriverFactory.getDriverFactory(browserType).getDriver();
                drivers.set(driver);
                createdDrivers.add(driver);
            }
        }
        return drivers.get();
    }

    public static BrowserType getBrowserType() {
        return browserType;
    }

    public static void setBrowserType(BrowserType browserType) {
        DriverManager.browserType = browserType;
    }

    public static void quitAll() {
        LOGGER.info("Quit all created drivers.");
        for (WebDriver driver : createdDrivers) {
            driver.quit();
        }
    }

}
