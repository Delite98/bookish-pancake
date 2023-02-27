package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import services.Properties;

public class SingletonDriver {
    private static WebDriver driver;
    private static String BROWSER = Properties.getBrowser().toLowerCase();

    private SingletonDriver() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (BROWSER) {
                case "chrome": {
                    chrome();
                    break;
                }
                default: {
                    try {
                        System.out.println("Browser " + BROWSER + " is not supported.");
                    } catch (Exception e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    break;
                }
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    private static void chrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
