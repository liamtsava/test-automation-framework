package automation.core.runner.cli;

public enum CliParam {
    
    BROWSER_TYPE("browserType"), GROUP("group");

    private String name;

    CliParam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
