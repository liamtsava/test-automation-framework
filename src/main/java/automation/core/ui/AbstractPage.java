package automation.core.ui;

import org.openqa.selenium.WebDriver;

import automation.core.driver.DriverManager;

public abstract class AbstractPage {

    protected DriverManager driverManager;
    
    protected WebDriver driver;
    
    public AbstractPage(DriverManager driverManager) {
        this.driverManager = driverManager;
        this.driver = driverManager.getDriver();
    }
}
