package services;

import browser.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsService {
    private WebDriverWait wait;

    public WaitsService(Duration timeout) {
        wait = new WebDriverWait(SingletonDriver.getDriver(), timeout);
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement waitForBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
