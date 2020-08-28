package TestCase;

import BaseTest.EditTaskBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class EditTaskTestCase extends EditTaskBaseTest {

    @Feature("API de tarefa 'edit'")
    @DisplayName("EDITAR")
    @Description("Edita um dado tarefa da conta")
    @Issue("https://api-de-tarefas.herokuapp.com/tasks")
    @Test
    public void editarTarefas(){
        given()
                .spec(requestSpec)
        .when()
                .put()
        .then()
                .log().body()
                .spec(responseSpec)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas" + File.separator + "EditarTarefaJsonSchemas.json"));
    }
}
