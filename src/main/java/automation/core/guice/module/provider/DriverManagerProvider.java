package automation.core.guice.module.provider;

import com.google.inject.Provider;

import automation.core.driver.DriverManager;
import automation.core.runner.BrowserType;
import automation.core.runner.TestRunParameters;
import automation.core.runner.cli.CliParam;

public class DriverManagerProvider implements Provider<DriverManager> {

    @Override
    public DriverManager get() {
        DriverManager.setBrowserType(BrowserType.valueOf(TestRunParameters.getParam(CliParam.BROWSER_TYPE)));
        return DriverManager.getInstance();
    }

}
