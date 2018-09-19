package automation.core.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.asserts.SoftAssert;

import com.google.inject.Inject;

import automation.core.driver.DriverManager;
import automation.core.guice.module.FunctionalTestModule;
import automation.core.ui.page.WelcomePage;

@Guice(modules = FunctionalTestModule.class)
public class BaseTest {

    @Inject
    protected DriverManager driverManager;

    protected WelcomePage welcomePage;

    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void beforeTestSetUp() {
        softAssert = new SoftAssert();
        welcomePage = new WelcomePage(driverManager);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestCleanUp() {
        // just a guarantee in case if it was forgotten in test, but envoke assertAll method in test
        softAssert.assertAll();
    }

}
