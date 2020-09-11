package TestCase;

import BaseTest.UsuarioBaseTest;
import Utils.ObjectJson;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EditarUsuarioTestCase extends UsuarioBaseTest {

    @Test
    public void editarUsuario(){

        System.out.println("Editar usuario");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "ID");

        given()
                .log().body()
                .spec(requestSpec)
                .body(ObjectJson.editUser())
                .pathParam("id", id)
        .when()
                .put("/{id}")
        .then()
                .log().body()
                .statusCode(200)
                .spec(responseSpec);
    }
}
