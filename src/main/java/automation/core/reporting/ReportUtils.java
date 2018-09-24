package automation.core.reporting;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import automation.core.runner.constant.FrameworkConstant;
import automation.core.runner.util.FileUtil;

public final class ReportUtils {

    private static final Logger LOGGER = new Logger(ReportUtils.class);

    public static void removeReportArtifacts() {
        LOGGER.info("Remove report artifacts.");
        FileUtil.deleteQuitelySubdirectory(FrameworkConstant.REPORT_FOLDER);
        FileUtil.deleteQuitelySubdirectory(FrameworkConstant.RESULTS_FOLDER);
    }

    public static void generateReport() {
        CommandLine commandLine = new CommandLine("allure");
        commandLine.addArgument("generate");
        commandLine.addArgument(FileUtil.getDirectory(FrameworkConstant.RESULTS_FOLDER));
        commandLine.addArgument("-o");
        commandLine.addArgument(FileUtil.getDirectory(FrameworkConstant.REPORT_FOLDER));
        DefaultExecutor executor = new DefaultExecutor();
        try {
            executor.execute(commandLine);
        } catch (IOException ioEx) {
            LOGGER.error("Unable to generate Allure report", ioEx);
        }
    }

}
