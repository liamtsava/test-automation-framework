package automation.core.runner;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import automation.core.runner.cli.CliParam;

public class TestRunParameters {

    private static final Logger LOGGER = LogManager.getLogger(TestRunParameters.class);

    private static String url;

    private static String group;

    private static Map<String, String> params = new HashMap<>();

    public static String getUrl() {
        if (url == null) {
            setUrl(params.get("url"));
        }
        return url;
    }

    public static void setUrl(String urlStr) {
        url = urlStr;
    }

    public static String getGroup() {
        if (group == null) {
            setGroup(params.get("group").toUpperCase());
        }
        return group;
    }

    public static void setGroup(String groupName) {
        group = groupName;
    }

    public static Map<String, String> getParams() {
        return params;
    }

    public static void setParams(Map<String, String> paramsMap) {
        for (Map.Entry<String, String> mapEntry : paramsMap.entrySet()) {
            if (params.containsKey(mapEntry.getKey())) {
                LOGGER.debug("Run parameter '{}' will be overriden with a new value.", mapEntry.getKey());
            }
            LOGGER.debug("Set run parameter: {} = {}", mapEntry.getKey(), mapEntry.getValue());
            params.put(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    public static String getParam(CliParam param) {
        return params.get(param.getName());
    }

}
