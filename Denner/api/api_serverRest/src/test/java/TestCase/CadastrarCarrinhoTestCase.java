package TestCase;

import BaseTest.CarrinhoBaseTest;
import Models.CadastrarCarrinhoModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CadastrarCarrinhoTestCase extends CarrinhoBaseTest {

    private CadastrarCarrinhoModel[] cadastrarCarrinhoModel = new CadastrarCarrinhoModel[2];

    @Feature("API de Serverest 'Cadastrar carrinho'")
    @DisplayName("CADASTRAR CARRINHO")
    @Description("Cadastra dado do carrinho")
    @Issue("http://localhost:3000/carrinhos")
    @Test
    public void cadastrarCarrinho() throws JsonProcessingException {

        System.out.println("Cadastrar carrinho");

        String token = Utils.ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");

//============================================================================================================
        /*OK*/
//        String produtos = "{\n" +
//                "  \"produtos\": [\n" +
//                "    {\n" +
//                "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
//                "      \"quantidade\": 2\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";

//============================================================================================================
        /*ERRO*/
//        JSONObject jsonObjectToPost = new JSONObject();
//        JSONArray array = new JSONArray();
//        JSONObject arrayItem = new JSONObject();
//
//        arrayItem.put("idProduto", "BeeJh5lz3k6kSIzA");
//        arrayItem.put("quantidade", 3);
//
//        array.put(arrayItem.toString());
//
//        jsonObjectToPost.put("produtos", array.toString());
//
//        System.out.println("TESTE: " + jsonObjectToPost);

//============================================================================================================
        /*OK*/
//        ObjectMapper mapper = new ObjectMapper();
//        CadastrarCarrinhoModel itens1 = new CadastrarCarrinhoModel("BeeJh5lz3k6kSIzA", 2);
//        CadastrarCarrinhoModel itens2 = new CadastrarCarrinhoModel("K6leHdftCeOJj8BJ", 2);
//        Object[] objectsArray = {itens1, itens2};
//
//        String reqJson = null;
//        List<String> tagData = new ArrayList<String>();
//
//        for(Object obj : objectsArray){
//            reqJson = mapper.writeValueAsString(obj);
////            System.out.println("Teste0: " +reqJson);
//            tagData.add(reqJson);
//        }
//
////        System.out.println("Teste1: " + tagData);
//
//        HashMap<String,List<String>> finalReq = new HashMap<String, List<String>>();
//        finalReq.put("\"produtos\":", tagData);
//
//        String finalReqString = finalReq.toString();
////        System.out.println("Teste2: " + finalReqString);
//
//        finalReqString = finalReqString.replace("=", " ");
////        System.out.println("Teste3: " +finalReqString);
//============================================================================================================



//============================================================================================================

        String idCarrinho =
                given()
                        .log().body()
                        .spec(requestSpec)
                        .header("authorization", token)
//                        .body(produtos)
//                        .body(jsonObjectToPost)
//                        .body(finalReqString)
                        .body(printjsonarray)
                .when()
                        .post()
                .then()
                        .log().body()
                        .statusCode(201)
//                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "CadastrarProdutoJsonSchemas.json"))
                        .spec(responseSpec)
                        .extract().path("_id");

        Utils.ObjectsUtils.setPropertiesData("dadosCarrinho", "ID", idCarrinho);
    }
}
