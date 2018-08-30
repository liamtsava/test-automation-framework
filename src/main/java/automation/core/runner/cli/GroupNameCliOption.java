package automation.core.runner.cli;

import org.apache.commons.cli.Option;

public class GroupNameCliOption extends Option {
    
    private static final String DEFAULT = "FULL";

    private static final long serialVersionUID = 3430039792329790715L;

    public GroupNameCliOption() {
        super("groupName", true,
                "Group name." + "add list of groups");
    }
    
    public String parse() {
        return null;
        
    }

}
