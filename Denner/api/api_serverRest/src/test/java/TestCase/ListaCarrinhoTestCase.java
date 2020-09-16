package TestCase;

import BaseTest.CarrinhoBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ListaCarrinhoTestCase extends CarrinhoBaseTest {

    @Feature("API de Serverest 'Lista carrinho'")
    @DisplayName("LISTA CARRINHO")
    @Description("Lista dado do carrinho")
    @Issue("http://localhost:3000/carrinhos")
    @Test
    public void listaCarrinho(){

        System.out.println("Lista carrinho");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "ID");
        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

        given()
                .spec(requestSpec)
//                .header("Authorization", token)
//                .queryParam("_id", id)
//                .pathParam("teste", "elS3I3Oru6BNQwsd") // path
//                .queryParam("idUsuario", "0uxuPY0cbmQhpEz1") // query
        .when()
//                .get("/elS3I3Oru6BNQwsd") // direto
//                .get("/{teste}") // path
                .get() // query
        .then()
                .log().body()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "ListaCarrinhoJsonSchemas.json"))
                .spec(responseSpec);
    }
}
