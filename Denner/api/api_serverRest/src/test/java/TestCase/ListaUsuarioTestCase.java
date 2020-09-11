package TestCase;

import BaseTest.UsuarioBaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class ListaUsuarioTestCase extends UsuarioBaseTest {

    @Test
    public void listaUsuario(){

        System.out.println("Lista usuario");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "ID");

        given()
                .spec(requestSpec)
//                .queryParam("_id", id)
//                .queryParam("_id", "b0hqD49Pu7eHNhj9")
//                .queryParam("_id", "Twf8t49HykiPdj4P")
//                .queryParam("_id", "aoiEH7nPiTUpaEiC")
//                .queryParam("email", "fulano@qa.com")
//                .queryParam("email", "jeferson1@teste.com")
//                .queryParam("password", "teste")
        .when()
                .get()
        .then()
                .log().body()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "ListaUsuarioJsonSchemas.json"))
                .spec(responseSpec);
    }
}
