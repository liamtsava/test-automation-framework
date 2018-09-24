package automation.core.reporting;

import java.util.UUID;

import org.slf4j.LoggerFactory;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;

public class Logger {

    private org.slf4j.Logger logger;

    public Logger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String logMessage) {
        addLogToAllure(logMessage);
        logger.info(logMessage);
    }

    public void debug(String logMessage) {
        logger.debug(logMessage);
    }

    public void debug(String logMessage, Object... par) {
        logger.debug(logMessage, par);
    }

    public void addLogToAllure(String logMessage) {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult().withName(logMessage);
        result.setStatus(Status.PASSED);

        lifecycle.startStep(uuid, result);
        lifecycle.stopStep(uuid);
    }

    public void error(String message, Throwable t) {
        logger.error(message, t);
    }
}
