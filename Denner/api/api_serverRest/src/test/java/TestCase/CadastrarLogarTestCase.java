package TestCase;

import BaseTest.CadastrarUsuarioBaseTest;
import Utils.ObjectJson;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CadastrarLogarTestCase extends CadastrarUsuarioBaseTest {

    @Test
    public void createUser() throws IOException {
        String ID =
        given()
                .log().all()
                .spec(requestSpec)
                .body(ObjectJson.createLoginJsonObject())
        .when()
                .post()
        .then()
                .log().body()
                .spec(responseSpec)
                .extract().path("_id")
                ;
        System.out.println("ID: " + ID);

        Utils.ObjectsUtils.setPropertiesData("dadosUsuario", "_ID", ID);
    }


}
