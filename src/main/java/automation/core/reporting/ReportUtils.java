package automation.core.reporting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ReportUtils {

    private static final Logger LOGGER = LogManager.getLogger(ReportUtils.class);

    private static final String RESULTS_DIR = System.getProperty("user.dir") + File.separator + "allure-results";

    private static final String REPORT_DIR = System.getProperty("user.dir") + File.separator + "allure-report";

    public static void cleanReportDirectory() {
        LOGGER.info("Clearing report directory...");
        FileUtils.deleteQuietly(Paths.get(REPORT_DIR).toFile());
        FileUtils.deleteQuietly(Paths.get(RESULTS_DIR).toFile());
    }

    public static void generateReport() {
        CommandLine commandLine = new CommandLine("allure");
        commandLine.addArgument("generate");
        commandLine.addArgument(RESULTS_DIR);
        commandLine.addArgument("-o");
        commandLine.addArgument(REPORT_DIR);
        DefaultExecutor executor = new DefaultExecutor();
        try {
            executor.execute(commandLine);
        } catch (IOException ioEx) {
            LOGGER.error("Unable to generate Allure report", ioEx);
        }
    }

}
