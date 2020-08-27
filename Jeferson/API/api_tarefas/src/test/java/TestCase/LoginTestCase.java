package TestCase;

import BaseTest.LogarBaseTest;
import Utils.ObjectsUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class LoginTestCase extends LogarBaseTest {

    @Test
    public void login(){
        String token =
        given()
                .spec(requestSpec)
        .when()
                .post()
        .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().path("data.attributes.auth-token");

        ObjectsUtils.setPropertiesData("dadosInformacao", "token", token);
    }
}
