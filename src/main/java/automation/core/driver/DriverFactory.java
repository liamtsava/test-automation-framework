package automation.core.driver;

import automation.core.runner.BrowserType;

public class DriverFactory {
    
    public static WebDriverFactory getDriverFactory(BrowserType browserType) {
        
        switch(browserType) {
        case FIREFOX:
            return new FirefoxDriverFactory(); 
        case CHROME:
            return new ChromeDriverFactory();
        default:
            throw new RuntimeException("Unsupported browser type: " + browserType);
        }
        
    }

}
