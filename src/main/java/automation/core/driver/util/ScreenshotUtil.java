package automation.core.driver.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import automation.core.reporting.Logger;
import automation.core.runner.constant.FrameworkConstant;
import automation.core.runner.util.FileUtil;
import net.bytebuddy.utility.RandomString;

public final class ScreenshotUtil {

    private static final Logger LOGGER = new Logger(ScreenshotUtil.class);

    private static String screenshotDir;

    private ScreenshotUtil() {
    }

    public static File takeScreenshotFile(WebDriver driver) {
        LOGGER.debug("Taking screenshot");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = String.format("Screenshot_%d_%s", System.currentTimeMillis(),
                RandomString.make(5) + ".png");
        String screenshotPath = getScreenshotDir() + File.separator + screenshotName;

        File screenshotFile = new File(screenshotPath);
        try {
            FileUtils.copyFile(scrFile, screenshotFile);
        } catch (IOException e) {
            LOGGER.error("Failure during saving screenshot file.", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return screenshotFile;
    }

    public static byte[] takeScreenshot(WebDriver driver) {
        File screenshotFile = takeScreenshotFile(driver);
        try {
            return Files.readAllBytes(Paths.get(screenshotFile.getAbsolutePath()));
        } catch (IOException e) {
            LOGGER.error("Failure during reading screenshot file.", e);
            return new byte[0];
        }
    }

    public static String getScreenshotDir() {
        if (screenshotDir.endsWith(File.separator)) {
            return screenshotDir.substring(0, screenshotDir.length() - 1);
        }
        return screenshotDir;
    }

    public static void setScreenshotDir(String dir) {
        screenshotDir = dir;
    }

    public static void removeScreenshotsDirectory() {
        LOGGER.logTestInfo("Remove screenshots folder.");
        FileUtil.deleteQuitelySubdirectory(FrameworkConstant.SCREENSHOTS_FOLDER);
    }
}
