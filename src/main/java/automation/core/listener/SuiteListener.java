package automation.core.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import automation.core.driver.DriverManager;
import automation.core.driver.util.ScreenshotUtil;
import automation.core.reporting.ReportUtils;
import automation.core.runner.constant.FrameworkConstant;

public class SuiteListener implements ISuiteListener {

    private static final Logger LOGGER = LogManager.getLogger(SuiteListener.class);

    public void onStart(ISuite suite) {
        LOGGER.info("Start the suite.");
        ScreenshotUtil.setScreenshotDir(FrameworkConstant.SCREENSHOTS_FOLDER);
        
        ReportUtils.removeReportArtifacts();
        ScreenshotUtil.removeScreenshotsDirectory();
    }

    public void onFinish(ISuite suite) {
        LOGGER.info("Finish the suite.");
        ReportUtils.generateReport();
        DriverManager.quitAll();
    }

}
