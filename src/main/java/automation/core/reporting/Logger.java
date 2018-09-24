package automation.core.reporting;

import java.util.UUID;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;

public class Logger {
    
    public static void logMessage(String inMessage) {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult().withName(inMessage);
        result.setStatus(Status.PASSED);

        lifecycle.startStep(uuid, result);
        lifecycle.stopStep(uuid);
    }
}
