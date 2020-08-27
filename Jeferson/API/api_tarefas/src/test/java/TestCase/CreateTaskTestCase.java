package TestCase;

import BaseTest.CreateTaskBaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateTaskTestCase extends CreateTaskBaseTest {

    @Test
    public void listarTarefas(){
        given()
                .spec(requestSpec)
        .when()
                .post()
        .then()
                .log().body()
                .spec(responseSpec);
    }
}
