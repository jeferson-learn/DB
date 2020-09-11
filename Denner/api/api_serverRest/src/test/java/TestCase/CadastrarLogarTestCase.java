package TestCase;

import BaseTest.CadastrarUsuarioBaseTest;
import Utils.ObjectJson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CadastrarLogarTestCase extends CadastrarUsuarioBaseTest {

    @Test
    public void createUser() throws IOException {
//        String ID =
        Response response =
        given()
                .log().all()
                .spec(requestSpec)
                .body(ObjectJson.loginTest())
        .when()
                .post()
        .then()
                .log().body()
                .spec(responseSpec)
                .extract().response();

        String id = response.path("_id");
        String message = response.path("message");

        System.out.println("ID: " + id);
        System.out.println("MESSAGE: " + message);

        Utils.ObjectsUtils.setPropertiesData("dadosUsuario", "ID", id);
    }


}
