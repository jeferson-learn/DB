package TestCase;

import BaseTest.ListTaskBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ListTaskTestCase extends ListTaskBaseTest {

    @Feature("API de tarefa 'LIST'")
    @DisplayName("LISTA")
    @Description("As listas tarefa da conta")
    @Issue("https://api-de-tarefas.herokuapp.com/tasks")
    @Test
    public void listarTarefas(){
        given()
                .spec(requestSpec)
        .when()
                .get()
        .then()
                .log().body()
                .spec(responseSpec);
    }
}
