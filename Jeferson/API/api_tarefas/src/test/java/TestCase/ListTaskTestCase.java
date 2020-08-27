package TestCase;

import BaseTest.ListTaskBaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ListTaskTestCase extends ListTaskBaseTest {

    @Test
    public void listarTarefas(){
        given()
                .log().all()
                .spec(requestSpec)
        .when()
                .get()
        .then()
                .log().all()
                .spec(responseSpec);
    }
}
