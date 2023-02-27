package pages;

import base.BaseForm;
import base.elements.Button;
import browser.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStorePage extends BaseForm {

    public BookStorePage() {
        super(By.id("searchBox"), "Book store page");
    }

    private Button loginButtonMP = new Button(By.id("login"), "Login button on Main Page");

    private List<WebElement> listOfBooks() {
        return SingletonDriver.getDriver().findElements(By.className("mr-2"));
    }

    public void clickOnButtonLogin() {
        loginButtonMP.clickOnElement();
    }

    public Integer getBooksValue() {
        return listOfBooks().size();
    }

}
