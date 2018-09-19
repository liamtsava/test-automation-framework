package automation.core.runner.cli.option;

import org.apache.commons.cli.Option;

import automation.core.runner.cli.CliParam;

public class GroupNameCliOption extends Option {

    private static final long serialVersionUID = 3430039792329790715L;

    public GroupNameCliOption() {
        super(CliParam.GROUP.getName(), true,
                "Group name: " + "add list of groups");
    }

}
