package automation.core.runner;

import java.util.HashMap;
import java.util.Map;

public class TestRunParameters {

    private static String url;

    private static Map<String, String> defaultParams = new HashMap<>();

    public static String getUrl() {
        if (url == null) {
            setUrl(defaultParams.get("url"));
        }
        return url;
    }

    public static void setUrl(String urlStr) {
        url = urlStr;
    }

    public static Map<String, String> getDefaultParams() {
        return defaultParams;
    }

    public static void setDefaultParams(Map<String, String> defaultParamsMap) {
        defaultParams = defaultParamsMap;
    }

}
