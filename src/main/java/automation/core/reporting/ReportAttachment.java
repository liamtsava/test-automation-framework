package automation.core.reporting;

import io.qameta.allure.Attachment;

public final class ReportAttachment {

    private static final Logger LOGGER = new Logger(ReportAttachment.class);

    private ReportAttachment() {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }

}
