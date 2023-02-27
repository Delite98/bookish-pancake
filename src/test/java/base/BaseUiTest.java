package base;

import browser.SingletonDriver;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.Properties;

public class BaseUiTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = SingletonDriver.getDriver();
        driver.get(Properties.getUrl());
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        SingletonDriver.closeDriver();
    }
}
