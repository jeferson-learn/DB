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

public class ConcluirComprarCarrinhoTestCase extends CarrinhoBaseTest {

    @Feature("API de Serverest 'Concluir comprar carrinho'")
    @DisplayName("CONCLUIR COMPRAR CARRINHO")
    @Description("Concluir comprar do produto carrinho")
    @Issue("http://localhost:3000/carrinhos/concluir-compra")
    @Test
    public void concluirComprarCarrinho(){

        System.out.println("Concluir comprar carrinho");

        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

        given()
                .spec(requestSpec)
                .header("authorization", token)
        .when()
                .delete("/concluir-compra")
        .then()
                .log().body()
                .statusCode(200)
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "ConcluirComprarCarrinhoJsonSchemas.json"))
                .spec(responseSpec);

    }
}
