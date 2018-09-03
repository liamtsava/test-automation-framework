package automation.core.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.google.inject.Inject;

import automation.core.runner.TestRunParameters;

public class BaseTest {

    @Inject
    protected WebDriver driver;

    protected SoftAssert softAssert;

    protected String url;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteSetUp() {
        url = TestRunParameters.getUrl();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTestSetUp() {
        softAssert = new SoftAssert();
    }

    @AfterTest(alwaysRun = true)
    public void afterTestCleanUp() {
        // just a guarantee in case if it was forgotten in test, but envoke assertAll method in test
        softAssert.assertAll();

        driver.quit();
    }

}
