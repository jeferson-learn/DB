package TestCase;

import BaseTest.UsuarioBaseTest;
import Utils.ObjectJson;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeletarUsuario extends UsuarioBaseTest {

    @Test
    public void deletarUsuario(){

        System.out.println("Deletar usuario");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "ID");

        given()
                .spec(requestSpec)
                .pathParam("id", id)
        .when()
                .delete("/{id}")
        .then()
                .log().body()
                .statusCode(200)
                .spec(responseSpec);
    }
}
