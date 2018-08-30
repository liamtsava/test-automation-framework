package automation.core.runner;

public enum BrowserType {

    FIREFOX("firefox"), CHROME("chrome");

    private String browserName;

    BrowserType(String browserName) {
        this.browserName = browserName;
    }

    public String getName() {
        return browserName;
    }
}
