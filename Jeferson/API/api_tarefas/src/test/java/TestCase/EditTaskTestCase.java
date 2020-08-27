package TestCase;

import BaseTest.EditTaskBaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EditTaskTestCase extends EditTaskBaseTest {

    @Test
    public void editarTarefas(){
        given()
                .spec(requestSpec)
        .when()
                .put()
        .then()
                .log().body()
                .spec(responseSpec);
    }
}
