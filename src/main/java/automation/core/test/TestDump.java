package automation.core.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.core.driver.DriverFactory;
import automation.core.runner.BrowserType;

public class TestDump {
    
    @Test(groups = "FULL")
    public void basicTest() {
        
//        WebDriver driver = DriverFactory.getDriverFactory(BrowserType.CHROME).getDriver();
//        
//        //Launch the Online Store Website
//        driver.get("http://www.google.com");
// 
//        // Print a Log In message to the screen
//        System.out.println("Successfully opened the website");
// 
//        // Close the driver
//        driver.quit();
        
        Assert.assertTrue(true);
    }

}
