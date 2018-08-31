package automation.core.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import automation.core.guice.module.FunctionalTestModule;
import automation.core.runner.TestRunParameters;
import automation.core.ui.page.WelcomePage;

@Guice(modules = FunctionalTestModule.class)
public class TestDump2 {

//    @Inject
//    private WebDriver driver;
//    
//    @Inject
//    private WelcomePage welcomePage;

    @Test(groups = "FULL")
    public void basicTest2() {

//        // Launch the Online Store Website
//        driver.get(TestRunParameters.getUrl());
//        
//        System.out.println(welcomePage.getTitle());
//
//        // Print a Log In message to the screen
//        System.out.println("Successfully opened the website");
//
//        // Close the driver
//        driver.quit();
//
//        Assert.assertTrue(true);
    }

}
