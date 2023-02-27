package tests;

import api.BooksModal;
import api.Endpoints;
import base.BaseUiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStorePage;
import parser.GsonParser;

import java.util.List;

import static io.restassured.RestAssured.given;

public class checkListOfBooksTest extends BaseUiTest {

    @Test
    public void checkListOfBooksTest() {
        BookStorePage bookStorePage = new BookStorePage();

        int booksUiValue = bookStorePage.getBooksValue();

        Response response = given()
                .get(Endpoints.BASE_URI+ Endpoints.GET_BOOKS);

        List<BooksModal> listBooksApiValue =
                new Gson().fromJson(response.getBody().asString(),
                        BooksModal.class).getBooks();

        int booksApiValue = listBooksApiValue.size();

        Assert.assertEquals(booksUiValue, booksApiValue, "Value of books isn't compare");
    }
}
