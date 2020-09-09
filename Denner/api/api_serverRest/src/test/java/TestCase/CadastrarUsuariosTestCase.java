package TestCase;

import BaseTest.CadastrarUsuarioBaseTest;
import Utils.ObjectJson;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CadastrarUsuariosTestCase extends CadastrarUsuarioBaseTest {

    @Test
    public void createUser(){
        String ID =
        given()
                .log().all()
                .spec(requestSpec)
                .body(ObjectJson.createLoginJsonObject())
        .when()
                .post()
        .then()
                .log().body()
                .spec(responseSpec)
                .extract().path("_id")
                ;
        System.out.println("ID: " + ID);
    }


}
