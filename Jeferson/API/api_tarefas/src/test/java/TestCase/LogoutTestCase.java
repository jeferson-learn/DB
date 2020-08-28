package TestCase;

import BaseTest.LogarBaseTest;
import Utils.ObjectsUtils;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class LogoutTestCase extends LogarBaseTest {

    @Feature("API de tarefa 'logout'")
    @DisplayName("DESLOGAR")
    @Description("Deslogar da conta")
    @Issue("https://api-de-tarefas.herokuapp.com/sessions")
    @Test
    public void logout(){
        String token = ObjectsUtils.getPropertiesData("dadosInformacao", "token");
        given()
                .spec(requestSpec)
        .when()
                .delete("/"+token)
        .then()
                .statusCode(204);
    }

}
