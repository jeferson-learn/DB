package TestCase;

import BaseTest.CreateUserBaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CreateUserTestCase extends CreateUserBaseTest {

    @Feature("API de tarefa 'create user'")
    @DisplayName("CRIAR USUARIO")
    @Description("Cria uma conta da tarefa")
    @Issue("https://api-de-tarefas.herokuapp.com/users")
    @Test
    public void createUser(){
        given()
                .log().all()
                .spec(requestSpec)
        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpec);
    }
}
