package TestCase;

import BaseTest.DeleteTaskBaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteTaskTestCase extends DeleteTaskBaseTest {

    @Test
    public void DeleteTarefas(){
        given()
                .spec(requestSpec)
        .when()
                .delete("/492")
        .then()
                .log().body()
                .spec(responseSpec);
    }

}
