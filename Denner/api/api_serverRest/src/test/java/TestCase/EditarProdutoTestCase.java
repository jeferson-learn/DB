package TestCase;

import BaseTest.ProdutoBaseTest;
import Models.EditarProdutoModel;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class EditarProdutoTestCase extends ProdutoBaseTest {

    private EditarProdutoModel editarProdutoModel = new EditarProdutoModel();

    @Feature("API de Serverest 'Editar'")
    @DisplayName("EDITAR")
    @Description("Editar produto")
    @Issue("http://localhost:3000/login")
    @Test
    public void editarProduto(){

        System.out.println("Editar produto");

        String id = Utils.ObjectsUtils.getPropertiesData("dadosProduto", "ID");
        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

        given()
                .log().body()
                .spec(requestSpec)
                .header("Authorization", token)
                .queryParam("_id", id)
//                .pathParam("id", "elS3I3Oru6BNQwsd")
//                .queryParam("_id", "K6leHdftCeOJj8BJ")
                .body(editarProdutoModel)
        .when()
                .put(id)
        .then()
                .log().body()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "EditarProdutoJsonSchemas.json"))
                .spec(responseSpec);
    }
}
