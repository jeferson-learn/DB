package verbosREST;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class VerbosTest {

    @Test
    public void deveSalvarUsuario(){
        given()
                .log().all()
                .contentType("application/json")
                .body("{ \"name\": \"Jeferson\", \"age\": 50 }")
        .when()
                .post("https://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("id", is(notNullValue()))
                .body("name", is("Jeferson"))
                .body("age", is(50))
                ;
    }
}
