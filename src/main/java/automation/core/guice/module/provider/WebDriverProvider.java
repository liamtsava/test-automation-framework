package automation.core.guice.module.provider;

import org.openqa.selenium.WebDriver;

import com.google.inject.Provider;

import automation.core.driver.DriverFactory;
import automation.core.runner.BrowserType;

public class WebDriverProvider implements Provider<WebDriver>{

    @Override
    public WebDriver get() {
        
        return DriverFactory.getDriverFactory(BrowserType.CHROME).getDriver();
    }

}
