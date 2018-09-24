package automation.core.runner.cli;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import automation.core.reporting.Logger;

public class CliManager {

    private static final Logger LOGGER = new Logger(CliManager.class);

    private Options options;

    private String[] args;

    public CliManager(String[] args) {
        this.args = args;
        this.options = new Options();
    }

    public void addCliParameter(Option option) {
        options.addOption(option);
    }

    public Map<String, String> parseParameters() throws ParseException {
        Map<String, String> cliParams = new HashMap<>();

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        for (Option option : options.getOptions()) {
            String optionName = option.getOpt();
            if (cmd.getOptionValue(optionName) != null) {
                cliParams.put(optionName, cmd.getOptionValue(optionName));
            } else {
                LOGGER.debug("Cli parameter '{}' has no option value.", optionName);
            }
        }
        return cliParams;
    }

}
