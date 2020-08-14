package API_Tarefas;

import JSONObject.TarefaJson;
import Models.CriarUsuarioModel;
import Models.LoginModel;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TarefasTest extends BaseTest{

    @Test
    @Order(1)
    public void criarUsuario(){
        Map<String, CriarUsuarioModel> objetoCriarUsuario = new HashMap<String, CriarUsuarioModel>();
        objetoCriarUsuario.put("user", criarUsuarioModel);

        given()
                .spec(requestSpec)
                .body(objetoCriarUsuario)
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .log().body();
    }

    @Test
    @Order(2)
    public void loginUsuario(){
        Map<String, LoginModel> objetoLogin = new HashMap<String, LoginModel>();
        objetoLogin.put("session", loginModel);

        token =
        given()
                .spec(requestSpec)
                .body(objetoLogin)
        .when()
                .post("/sessions")
        .then()
                .spec(responseSpec)
                .log().body()
                .extract().path("data.attributes.'auth-token'");

//        System.out.println("Teste TOKEN: " + token);
//        criarDadoTarefa();
//        listaTarefa();
//        editarTarefa();
//        deletaTarefa();
//        logoutTarefa();
    }

    @Test
    @Order(3)
    public void criarDadoTarefa(){
        TarefaJson criandoDadoJson = new TarefaJson();
        given()
                .spec(requestSpec)
                .body(criandoDadoJson.dadoTarefa())
                .header("Authorization", token)
        .when()
                .post("/tasks")
        .then()
                .statusCode(201)
                .log().body();
    }

    @Test
    @Order(4)
    public void listaTarefa(){
        id =
        given()
                .spec(requestSpec)
                .header("Authorization", token)
        .when()
                .get("/tasks")
        .then()
                .spec(responseSpec)
                .log().body()
                .extract().path("data[0].id");
    }

    @Test
    @Order(5)
    public void editarTarefa(){
        TarefaJson editandoDadoJson = new TarefaJson();
        given()
                .spec(requestSpec)
                .body(editandoDadoJson.editarTarefa())
                .header("Authorization", token)
        .when()
                .put("/tasks/"+id)
        .then()
                .spec(responseSpec)
                .log().body();
    }

    @Test
    @Order(6)
    public void deletaTarefa(){
        given()
                .spec(requestSpec)
                .header("Authorization", token)
        .when()
                .delete("/tasks/"+id)
        .then()
                .statusCode(204)
                .log().body();
    }

    @Test
    @Order(7)
    public void logoutTarefa(){
        given()
                .spec(requestSpec)
        .when()
                .delete("/sessions/"+token)
        .then()
                .statusCode(204)
                .log().body();
    }

}
