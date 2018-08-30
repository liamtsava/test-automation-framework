package automation.core.driver;

import org.openqa.selenium.chrome.ChromeDriver;

import automation.core.driver.DriverConstants.DriverConfigs;

public class ChromeDriverFactory implements WebDriverFactory {
    

    @Override
    public ChromeDriver getDriver() {
        
        String chromeBinary = DriverConstants.PATH_TO_DRIVERS + DriverConstants.CHROME_DRIVER_SUBFOLDER + "chromedriver";
        System.setProperty(DriverConfigs.CHROME_SYS_PROP_NAME, chromeBinary);
        
        return new ChromeDriver();
    }

}
