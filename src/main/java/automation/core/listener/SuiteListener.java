package automation.core.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import automation.core.reporting.ReportUtils;

public class SuiteListener implements ISuiteListener {

    private static final Logger LOGGER = LogManager.getLogger(SuiteListener.class);

    public void onStart(ISuite suite) {
        LOGGER.info("Start the suite.");
        ReportUtils.cleanReportDirectory();
    }

    public void onFinish(ISuite suite) {
        LOGGER.info("Finish the suite.");
        ReportUtils.generateReport();
    }

}
