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

    @Test
    public void deveAlterarUsuario(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Nome alterado\", \"age\": 25 }")
        .when()
                .put("https://restapi.wcaquino.me/users/1")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Nome alterado"))
                .body("age", is(25))
        ;
    }

    @Test
    public void devoCustomizarURLParte1(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Nome alterado\", \"age\": 25 }")
        .when()
//                .put("https://restapi.wcaquino.me/users/1")
                .put("https://restapi.wcaquino.me/{entidade}/{userID}", "users", "1")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Nome alterado"))
                .body("age", is(25))
        ;
    }

    @Test
    public void devoCustomizarURLParte2(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Nome alterado\", \"age\": 25 }")
                .pathParam("entidade", "users")
                .pathParam("userID", "1")
        .when()
//                .put("https://restapi.wcaquino.me/users/1")
                .put("https://restapi.wcaquino.me/{entidade}/{userID}")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Nome alterado"))
                .body("age", is(25))
        ;
    }

    @Test
    public void devoDeletarUsuario(){
        given()
                .log().all()
        .when()
                .delete("https://restapi.wcaquino.me/users/1")
        .then()
                .log().all()
                .statusCode(204)
        ;
    }

    @Test
    public void naoDevoDeletarUsuarioInexistente(){
        given()
                .log().all()
        .when()
                .delete("https://restapi.wcaquino.me/users/1000")
        .then()
                .log().all()
                .statusCode(400)
                .body("error", is("Registro inexistente"))
        ;
    }

}
