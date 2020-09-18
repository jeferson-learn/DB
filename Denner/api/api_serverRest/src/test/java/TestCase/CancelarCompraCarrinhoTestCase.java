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

public class CancelarCompraCarrinhoTestCase extends CarrinhoBaseTest {

    @Feature("API de Serverest 'Cancela comprar carrinho'")
    @DisplayName("CANCELA COMPRAR CARRINHO")
    @Description("Cancela comprar do produto carrinho")
    @Issue("http://localhost:3000/carrinhos/cancelar-compra")
    @Test
    public void cancelaComprarCarrinho(){

        System.out.println("Cancela comprar carrinho");

        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

            given()
                    .spec(requestSpec)
                    .header("authorization", token)
            .when()
                    .delete("/cancelar-compra")
            .then()
                    .log().body()
                    .statusCode(200)
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "CancelarComprarCarrinhoJsonSchemas.json"))
                    .spec(responseSpec);

    }
}
