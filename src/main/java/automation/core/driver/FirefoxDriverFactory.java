package automation.core.driver;

import org.openqa.selenium.firefox.FirefoxDriver;

import automation.core.driver.DriverConstants.DriverConfigs;

public class FirefoxDriverFactory implements WebDriverFactory {

    @Override
    public FirefoxDriver getDriver() {
        
        String firefoxBinary = DriverConstants.PATH_TO_DRIVERS + DriverConstants.FIREFOX_DRIVER_SUBFOLDER + "geckodriver";
        System.setProperty(DriverConfigs.FIREFOX_SYS_PROP_NAME, firefoxBinary);
        
        return new FirefoxDriver();
    }
    
}
