package TestCase;

import BaseTest.LoginBaseTest;
import Utils.ObjectsUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class LoginTestCase extends LoginBaseTest {

    @Test
    public void login(){
        String token =
        given()
                .spec(requestSpec)
        .when()
                .post()
        .then()
                .spec(responseSpec)
                .extract().path("data.attributes.auth-token");

        ObjectsUtils.setPropertiesData("dadosInformacao", "token", token);
    }
}
