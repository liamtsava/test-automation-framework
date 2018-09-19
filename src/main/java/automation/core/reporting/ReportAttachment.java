package automation.core.reporting;

import io.qameta.allure.Attachment;

public final class ReportAttachment {

    private ReportAttachment() {
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
