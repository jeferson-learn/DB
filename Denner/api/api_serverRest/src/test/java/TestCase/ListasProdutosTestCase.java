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

public class ListasProdutosTestCase extends ProdutoBaseTest {

    @Feature("API de Serverest 'Lista produto'")
    @DisplayName("LISTA PRODUTO")
    @Description("Lista dado do produto")
    @Issue("http://localhost:3000/produtos")
    @Test
    public void listaProduto(){

        System.out.println("Produto usuario");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "ID");
        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

        given()
                .spec(requestSpec)
//                .header("Authorization", token)
//                .queryParam("_id", id)
//                .pathParam("teste", "elS3I3Oru6BNQwsd") // path
//                .queryParam("_id", "elS3I3Oru6BNQwsd") // query
        .when()
//                .get("/elS3I3Oru6BNQwsd") // direto
//                .get("/{teste}") // path
                .get() // query
        .then()
                .log().body()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "ListaProdutoJsonSchemas.json"))
                .spec(responseSpec);
    }
}
