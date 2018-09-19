package automation.core.runner.cli.option;

import java.util.Arrays;

import org.apache.commons.cli.Option;

import automation.core.runner.BrowserType;
import automation.core.runner.cli.CliParam;

public class BrowserCliOption extends Option {

    private static final long serialVersionUID = 3430039792329790715L;

    public BrowserCliOption() {
        super(CliParam.BROWSER_TYPE.getName(), true,
                "Supported browser types: " + Arrays.toString(BrowserType.values()).toUpperCase());
    }

}
