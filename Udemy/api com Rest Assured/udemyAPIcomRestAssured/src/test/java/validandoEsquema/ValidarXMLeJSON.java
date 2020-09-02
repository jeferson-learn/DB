package validandoEsquema;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ValidarXMLeJSON {

    @Test
    public void deveValidarSchemasXML(){
        given()
                .log().all()
        .when()
                .get("http://restapi.wcaquino.me/usersXML")
        .then()
                .log().all()
                .statusCode(200)
                .body(RestAssuredMatchers.matchesXsdInClasspath("users.xsd"))
        ;
    }

//    @Test(expected = SAXParseException.class)
//    public void deveInvalidarSchemasXML(){
//        Assertions.assertThrows(SAXParseException.class, () -> {Integer.parseInt("One");});
//        given()
//                .log().all()
//        .when()
//                .get("https://restapi.wcaquino.me/invalidusersXML")
//        .then()
//                .log().all()
//                .statusCode(200)
//                .body(RestAssuredMatchers.matchesXsdInClasspath("users.xsd"))
//        ;
//    }

    @Test
    public void deveValidarSchemasJSON(){
        given()
                .log().all()
        .when()
                .get("http://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("users.json"))
        ;
    }


}
