package automation.core.reporting;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.qameta.allure.Allure;

public final class ReportAttachment {

    private static final Logger LOGGER = LogManager.getLogger(ReportAttachment.class);

    private ReportAttachment() {
    }

    public static void attachScreenshot(File file) {
        Path content = Paths.get(file.getAbsolutePath());
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("Screenshot", is);
        } catch (IOException e) {
            LOGGER.error("Failure during attaching screenshot file.", e);
        }

    }

}
