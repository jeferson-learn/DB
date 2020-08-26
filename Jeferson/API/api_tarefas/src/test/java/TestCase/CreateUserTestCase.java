package TestCase;

import BaseTest.CreateUserBaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CreateUserTestCase extends CreateUserBaseTest {

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
