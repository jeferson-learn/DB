package TestCase;

import BaseTest.CreateTaskBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateTaskTestCase extends CreateTaskBaseTest {

    @Feature("API de tarefa 'create'")
    @DisplayName("CRIAR TAREFA")
    @Description("Criar um dado tarefa da conta")
    @Issue("https://api-de-tarefas.herokuapp.com/tasks")
    @Test
    public void criarTarefas(){
        given()
                .spec(requestSpec)
        .when()
                .post()
        .then()
                .log().body()
                .spec(responseSpec)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas" + File.separator + "CriarTarefaJsonSchemas.json"))
        ;
    }
}
