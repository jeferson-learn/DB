package TestCase;

import BaseTest.LogarBaseTest;
import Utils.ObjectsUtils;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class LoginTestCase extends LogarBaseTest {

    @Feature("API de tarefa 'login'")
    @DisplayName("LOGAR")
    @Description("Logar da conta")
    @Issue("https://api-de-tarefas.herokuapp.com/sessions")
    @Test
    public void login(){
        String token =
        given()
                .spec(requestSpec)
        .when()
                .post()
        .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().path("data.attributes.auth-token");

        ObjectsUtils.setPropertiesData("dadosInformacao", "token", token);
    }
}
