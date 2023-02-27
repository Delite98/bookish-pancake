package tests;

import api.UserModel;
import base.BaseUiTest;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.LoginPage;
import parser.GsonParser;

public class loginTest extends BaseUiTest {
    GsonParser gsonParser = new GsonParser();
    UserModel createUser = gsonParser.parserUserModel("src/test/resources/user.json");

    @Test
    public void loginTest() {
        BookStorePage bookStorePage = new BookStorePage();
        LoginPage loginPage = new LoginPage();

        bookStorePage.clickOnButtonLogin();
        loginPage.insertUserName(createUser.getUserName());
        loginPage.insertPassword(createUser.getPassword());
        loginPage.clickOnLoginButton();
    }
}
