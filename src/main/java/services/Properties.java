package services;

import java.io.IOException;

public class Properties {
    private static java.util.Properties properties;
    private static String filename = "configData.properties";

    static {
        properties = new java.util.Properties();
        try {
            properties.load(Properties.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
    public static String getApiUri() {
        return properties.getProperty("apiUri");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("pageLoadTimeout"));
    }

    public static int getTimeoutOfElement() {
        return Integer.parseInt(properties.getProperty("timeoutOfElement"));
    }

}
