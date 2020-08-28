package TestCase;

import BaseTest.DeleteTaskBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteTaskTestCase extends DeleteTaskBaseTest {

    @Feature("API de tarefa 'delete'")
    @DisplayName("APAGAR")
    @Description("Apaga um dado tarefa da conta")
    @Issue("https://api-de-tarefas.herokuapp.com/tasks")
    @Test
    public void DeleteTarefas(){
        given()
                .spec(requestSpec)
        .when()
                .delete("/491")
        .then()
                .log().body()
                .spec(responseSpec);
    }

}
