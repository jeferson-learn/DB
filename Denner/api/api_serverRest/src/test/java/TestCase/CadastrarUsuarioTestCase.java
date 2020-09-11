package TestCase;

import BaseTest.UsuarioBaseTest;
import Utils.ObjectJson;
import Utils.ObjectsUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CadastrarUsuarioTestCase extends UsuarioBaseTest {

    @Test
    public void cadastrarUsuario(){

        System.out.println("Cadastrar usuario");

        String ID =
        given()
                .spec(requestSpec)
                .body(ObjectJson.createUser())
        .when()
                .post()
        .then()
                .log().body()
                .statusCode(201)
                .spec(responseSpec)
                .extract().path("_id");
        Utils.ObjectsUtils.setPropertiesData("dadosUsuario", "ID", ID);
    }

}
