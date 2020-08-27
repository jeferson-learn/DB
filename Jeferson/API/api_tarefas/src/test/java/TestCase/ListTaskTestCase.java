package TestCase;

import BaseTest.ListTaskBaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ListTaskTestCase extends ListTaskBaseTest {

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
