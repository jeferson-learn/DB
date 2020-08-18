package serialização;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Sinalizando {

    @Test
    public void deveSalvarUsuarioUsandoMAP(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Usuario via MAP");
        params.put("age", 25);

        given()
                .log().all()
                .contentType("application/json")
                .body(params)
        .when()
                .post("https://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("id", is(notNullValue()))
                .body("name", is("Usuario via MAP"))
                .body("age", is(25))
        ;
    }

    @Test
    public void deveSalvarUsuarioUsandoObjeto(){
        User user = new User("Usuario via objeto", 30);

        given()
                .log().all()
                .contentType("application/json")
                .body(user)
        .when()
                .post("https://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("id", is(notNullValue()))
                .body("name", is("Usuario via objeto"))
                .body("age", is(30))
        ;
    }
}
