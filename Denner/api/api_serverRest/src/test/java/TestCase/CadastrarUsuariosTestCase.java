package TestCase;

import BaseTest.UsuarioBaseTest;
import Models.CreateLoginModel;
import Utils.ObjectJson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CadastrarUsuariosTestCase extends UsuarioBaseTest {

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
