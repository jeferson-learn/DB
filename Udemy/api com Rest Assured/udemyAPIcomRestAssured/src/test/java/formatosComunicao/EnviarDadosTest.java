package formatosComunicao;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EnviarDadosTest {

    @Test
    public void deveEnviarValorViaQueryXML(){
        given()
                .log().all()
        .when()
                .get("https://restapi.wcaquino.me/v2/users?format=xml")
        .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.XML)
        ;
    }

    @Test
    public void deveEnviarValorViaQueryJSON(){
        given()
                .log().all()
        .when()
                .get("https://restapi.wcaquino.me/v2/users?format=json")
        .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
        ;
    }

    @Test
    public void deveEnviarValorViaQueryViaParam(){
        given()
                .log().all()
//                .param("format", "xml")
                .param("format", "json")
        .when()
                .get("https://restapi.wcaquino.me/v2/users")
        .then()
                .log().all()
                .statusCode(200)
//                .contentType(ContentType.XML)
                .contentType(ContentType.JSON)
                .contentType(Matchers.containsString("utf-8"))
        ;
    }
}
