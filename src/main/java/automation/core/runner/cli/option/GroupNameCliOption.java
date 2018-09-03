package automation.core.runner.cli.option;

import org.apache.commons.cli.Option;

public class GroupNameCliOption extends Option {

    private static final long serialVersionUID = 3430039792329790715L;

    public GroupNameCliOption() {
        super("group", true,
                "Group name: " + "add list of groups");
    }

}
