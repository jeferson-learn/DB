package TestCase;

import BaseTest.ProdutoBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeletarProdutoTestCase extends ProdutoBaseTest {

    @Feature("API de Serverest 'DELETAR'")
    @DisplayName("DELETAR")
    @Description("Deleta produto")
    @Issue("http://localhost:3000/login")
    @Test
    public void deletarProduto(){

        System.out.println("Deletar produto");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosProduto", "ID");
        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

        given()
                .spec(requestSpec)
                .header("Authorization", token)
                .pathParam("id", id)
        .when()
                .delete("/{id}")
//                .delete()
        .then()
                .log().body()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "DeletarProdutoJsonSchemas.json"))
                .spec(responseSpec);
    }
}
