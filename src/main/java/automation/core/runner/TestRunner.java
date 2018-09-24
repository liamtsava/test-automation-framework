package automation.core.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.ParseException;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import automation.core.driver.DriverManager;
import automation.core.listener.SuiteListener;
import automation.core.listener.TestListener;
import automation.core.reporting.Logger;
import automation.core.runner.cli.CliManager;
import automation.core.runner.cli.option.BrowserCliOption;
import automation.core.runner.cli.option.GroupNameCliOption;

public class TestRunner {

    private static final Logger LOGGER = new Logger(TestRunParameters.class);

    public static void main(String[] args) throws Exception {

        try {
            CliManager cliManager = new CliManager(args);
            addCommandLineOptions(cliManager);

            TestNG testng = new TestNG();

            List<XmlSuite> suites = new ArrayList<XmlSuite>(new Parser().parse());
            testng.setXmlSuites(suites);

            TestRunParameters.setParams(extractDefaultRunParams(suites));
            TestRunParameters.setParams(cliManager.parseParameters());

            List<Class<? extends ITestNGListener>> listeners = new ArrayList<>();
            listeners.add(SuiteListener.class);
            listeners.add(TestListener.class);
            testng.setListenerClasses(listeners);

            testng.setGroups(TestRunParameters.getGroup());

            testng.run();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw e;
        } finally {
            DriverManager.quitAll();
        }
    }

    private static void addCommandLineOptions(CliManager cliManager) throws ParseException {

        cliManager.addCliParameter(new BrowserCliOption());
        cliManager.addCliParameter(new GroupNameCliOption());
    }

    private static Map<String, String> extractDefaultRunParams(List<XmlSuite> suites) {
        Map<String, String> allParams = new HashMap<>();
        for (XmlSuite suite : suites) {
            Map<String, String> suiteParams = suite.getParameters();
            // TODO some params may be missed in case of some suites
            // TODO parent testng.xml?
            allParams.putAll(suiteParams);
        }
        return allParams;
    }

}
