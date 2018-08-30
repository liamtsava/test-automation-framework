package automation.core.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import automation.core.listener.SuiteListener;
import automation.core.listener.TestListener;
import automation.core.runner.cli.BrowserCliOption;
import automation.core.runner.cli.GroupNameCliOption;

public class TestRunner {

    public static void main(String[] args) throws Exception {

        Options options = new Options();

        options.addOption(new BrowserCliOption());
        options.addOption(new GroupNameCliOption());

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        // String browser = cmd.getOptionValue("b") !=null? cmd.getOptionValue("b") : "CHROME";
        String group = cmd.getOptionValue("groupName") != null ? cmd.getOptionValue("groupName") : "FULL";

        TestNG testng = new TestNG();

        List<XmlSuite> suites = new ArrayList<XmlSuite>(new Parser().parse());
        testng.setXmlSuites(suites);

        TestRunParameters.setDefaultParams(extractDefaultRunParams(suites));

        List<Class<? extends ITestNGListener>> listeners = new ArrayList<>();
        listeners.add(SuiteListener.class);
        listeners.add(TestListener.class);
        testng.setListenerClasses(listeners);

        testng.setGroups(group);

        testng.run();
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
