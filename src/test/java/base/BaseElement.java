package base;

import browser.SingletonDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import services.Properties;
import services.WaitsService;

import java.time.Duration;

public abstract class BaseElement {
    private static final Logger logger = LogManager.getLogger(BaseElement.class);
    private WaitsService waitsService = new WaitsService(Duration.ofSeconds(Properties.getTimeoutOfElement()));
    JavascriptExecutor js = ((JavascriptExecutor) SingletonDriver.getDriver());


    private By uniqueLocator;
    private String elementName;

    public BaseElement(By uniqueLocator, String elementName) {
        this.uniqueLocator = uniqueLocator;
        this.elementName = elementName;
    }

    public void clickOnElement() {
        logger.info("Click on element {}", uniqueLocator);
        scrollToElement();
        waitsService.waitForBeClickable(uniqueLocator);
        getElement().click();
    }

    public void scrollToElement() {
        logger.info("Scroll to element {}", uniqueLocator);
        js.executeScript("arguments[0].scrollIntoView(true)",
                waitsService.waitForPresence(uniqueLocator));
    }

    protected WebElement getElement() {
        logger.info("Get element {}", uniqueLocator);
        return SingletonDriver.getDriver().findElement(uniqueLocator);
    }


}
