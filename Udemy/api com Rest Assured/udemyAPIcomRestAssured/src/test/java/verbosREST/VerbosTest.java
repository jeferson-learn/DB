package verbosREST;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void naoDeveSalvarUsuarioSemNome(){
        given()
                .log().all()
                .contentType("application/json")
                .body("{ \"age\": 50 }")
        .when()
                .post("https://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(400)
                .body("id", is(nullValue()))
                .body("error",is("Name é um atributo obrigatório"))
        ;
    }

    @Test
    public void deveSalvarUsuarioComXML(){
        given()
                .log().all()
                .contentType(ContentType.XML)
                .body("<user><name>Jeferson</name><age>50</age></user>")
        .when()
                .post("https://restapi.wcaquino.me/usersXML")
        .then()
                .log().all()
                .statusCode(201)
                .body("user.@id", is(notNullValue()))
                .body("user.name", is("Jeferson"))
                .body("user.age", is("50"))
        ;
    }

}
