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

        System.out.println("Lista produto usuario");

        given()
                .spec(requestSpec)
        .when()
                .get()
        .then()
                .log().body()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "ListaProdutoJsonSchemas.json"))
                .spec(responseSpec);
    }
}
