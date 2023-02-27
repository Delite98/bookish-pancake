package pages;

import base.BaseForm;
import base.elements.Button;
import base.elements.TextBox;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {
    public LoginPage() {
        super(By.id("userForm"), "Login Page");
    }

    private TextBox userName = new TextBox(By.id("userName"), "User name");

    private TextBox userPsw = new TextBox(By.id("password"), "User password");

    private Button loginButtonLP = new Button(By.id("login"), "Login button");

    public void insertUserName(String text) {
        userName.sendKeysElement(text);
    }

    public void insertPassword(String text) {
        userPsw.sendKeysElement(text);
    }

    public void clickOnLoginButton() {
        loginButtonLP.clickOnElement();
    }
}
