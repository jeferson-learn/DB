package barrigaTest;

import barrigaFW.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ContasTest extends BaseTest {

    @BeforeEach
    public void login() {

        Map<String, String> object = new HashMap<String, String>();
        object.put("email", "jefersonbarriga@hotmail.com");
        object.put("senha", "123456");

        String TOKEN =
                given()
                        .spec(requestSpec)
                        .body(object)
                .when()
                        .post("/signin")
                .then()
                        .log().body()
                        .statusCode(200)
                        .extract().path("token");

        requestSpec.header("Authorization", "JWT " + TOKEN);

        RestAssured.get("/reset").then().statusCode(200);
    }

    @Test
    public void deveIncluirContaComSucesso() {

        given()
                .spec(requestSpec)
                .body("{ \"nome\" : \"Conta inserido\" }")
        .when()
                .post("/contas")
        .then()
                .log().body()
                .statusCode(201);
    }
}
