package TestCase;

import BaseTest.UsuarioBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeletarUsuarioTestCase extends UsuarioBaseTest {

    @Feature("API de Serverest 'Deleta usuario'")
    @DisplayName("DELETAR USUARIO")
    @Description("Deleta dado do usuario")
    @Issue("http://localhost:3000/usuarios/{id}")
    @Test
    public void deletarUsuario(){

        System.out.println("Deletar usuario");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "ID");

        given()
                .spec(requestSpec)
                .pathParam("id", id)
        .when()
                .delete("/{id}")
//                .delete("/ujQHcot134QuB10c")
        .then()
                .log().body()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "DeletarUsuarioJsonSchemas.json"))
                .spec(responseSpec);
    }
}
