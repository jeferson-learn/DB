package TestCase;

import BaseTest.ProdutoBaseTest;
import Models.ProdutoModel;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CadastrarProdutoTestCase extends ProdutoBaseTest {

    private ProdutoModel produtoModel = new ProdutoModel();

    @Feature("API de Serverest 'Cadastrar produto'")
    @DisplayName("CADASTRAR PRODUTO")
    @Description("Cadastra dado do produto")
    @Issue("http://localhost:3000/produtos")
    @Test
    public void cadastrarProduto(){

        System.out.println("Cadastrar produto");

        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

        String idProduto =
        given()
                .log().body()
                .spec(requestSpec)
                .header("authorization", token)
                .body(produtoModel)
//                .queryParam("_id", id)
//                .queryParam("_id", "K6leHdftCeOJj8BJ")
        .when()
                .post()
        .then()
                .log().body()
                .statusCode(201)
//                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "ListaUsuarioJsonSchemas.json"))
                .spec(responseSpec)
                .extract().path("_id");

        Utils.ObjectsUtils.setPropertiesData("dadosProduto", "ID", idProduto);
    }
}
