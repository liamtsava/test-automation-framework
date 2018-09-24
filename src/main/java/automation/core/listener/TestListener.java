package automation.core.listener;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import automation.core.driver.DriverManager;
import automation.core.driver.util.ScreenshotUtil;
import automation.core.reporting.Logger;
import automation.core.reporting.ReportAttachment;

public class TestListener implements ITestListener, IInvokedMethodListener {

    private static final Logger LOGGER = new Logger(TestListener.class);

    public void onTestStart(ITestResult result) {
        LOGGER.debug("Starting test: " + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.debug("SUCCESS: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        LOGGER.debug("FAILURE: " + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.debug("SKIPPED: " + result.getMethod().getMethodName());
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

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            WebDriver driver = DriverManager.getInstance().getDriver();
            ReportAttachment.attachScreenshot(ScreenshotUtil.takeScreenshot(driver));
        }
    }

}
