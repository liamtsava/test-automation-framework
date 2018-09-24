package automation.core.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import automation.core.driver.DriverManager;
import automation.core.driver.util.ScreenshotUtil;
import automation.core.reporting.Logger;
import automation.core.reporting.ReportUtils;
import automation.core.runner.constant.FrameworkConstant;

public class SuiteListener implements ISuiteListener {

    private static final Logger LOGGER = new Logger(SuiteListener.class);

    public void onStart(ISuite suite) {
        LOGGER.debug("Start the suite.");
        ScreenshotUtil.setScreenshotDir(FrameworkConstant.SCREENSHOTS_FOLDER);
        
        ReportUtils.removeReportArtifacts();
        ScreenshotUtil.removeScreenshotsDirectory();
    }

    public void onFinish(ISuite suite) {
        LOGGER.debug("Finish the suite.");
        ReportUtils.generateReport();
        DriverManager.quitAll();
    }

}
