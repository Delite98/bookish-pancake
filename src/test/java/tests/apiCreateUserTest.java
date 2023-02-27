package tests;

import api.Endpoints;
import api.UserModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import parser.GsonParser;

import static io.restassured.RestAssured.given;

public class apiCreateUserTest {
    GsonParser gsonParser = new GsonParser();
    UserModel createUser = gsonParser.parserUserModel("src/test/resources/user.json");

    @Test
    public void createUser() {
        given().contentType("application/json")
                .body(createUser)
                .when()
                .post(Endpoints.BASE_URI+ Endpoints.POST_USER)
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
