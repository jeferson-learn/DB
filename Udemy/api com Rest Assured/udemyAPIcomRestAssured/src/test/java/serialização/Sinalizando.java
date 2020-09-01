package serialização;

import io.restassured.http.ContentType;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void deveDeserializarObjetoSalvarUsuario(){
        User user = new User("Usuario deserialzado", 30);

        User usuarioInserido =
        given()
                .log().all()
                .contentType("application/json")
                .body(user)
        .when()
                .post("https://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(201)
                .extract().body().as(User.class)
        ;

        System.out.println(usuarioInserido);
        MatcherAssert.assertThat(usuarioInserido.getId(), notNullValue());
        Assertions.assertEquals("Usuario deserialzado", usuarioInserido.getName());
        Assertions.assertTrue(usuarioInserido.getAge() == 30);
    }

    @Test
    public void deveObjetoSalvarUsuarioComXML(){
        User user = new User("Usuario XML", 40);

        given()
                .log().all()
                .contentType(ContentType.XML)
                .body(user)
        .when()
                .post("https://restapi.wcaquino.me/usersXML")
        .then()
                .log().all()
                .statusCode(201)
                .body("user.@id", is(notNullValue()))
                .body("user.name", is("Usuario XML"))
                .body("user.age", is("40"))
        ;
    }

    @Test
    public void deveDeserializarXMLSalvarUsuario(){
        User user = new User("Usuario XML", 40);

        User usuarioInserido =
        given()
                .log().all()
                .contentType(ContentType.XML)
                .body(user)
        .when()
                .post("https://restapi.wcaquino.me/usersXML")
        .then()
                .log().all()
                .statusCode(201)
                .extract().body().as(User.class)
        ;

//        System.out.println(usuarioInserido);
        MatcherAssert.assertThat(usuarioInserido.getId(), notNullValue());
        MatcherAssert.assertThat(usuarioInserido.getName(), is("Usuario XML"));
        MatcherAssert.assertThat(usuarioInserido.getAge(), is(40));
        MatcherAssert.assertThat(usuarioInserido.getSalary(), nullValue());

    }

}
