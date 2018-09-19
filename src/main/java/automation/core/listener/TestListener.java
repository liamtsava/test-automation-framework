package automation.core.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import automation.core.driver.DriverManager;
import automation.core.driver.util.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result) {
        LOGGER.info("Starting test: " + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.info("SUCCESS: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        LOGGER.info("FAILURE: " + result.getMethod().getMethodName());
        WebDriver driver = DriverManager.getInstance().getDriver();
        ScreenshotUtil.takeScreenshot(driver);
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.info("SKIPPED: " + result.getMethod().getMethodName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }

}
