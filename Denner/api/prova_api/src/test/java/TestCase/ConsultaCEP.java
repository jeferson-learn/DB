package TestCase;

import base.BaseTest;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class ConsultaCEP extends BaseTest {

    @Feature("CEP VÁLIDO")
    @DisplayName("Consulta CEP válido")
    @Description("O usuário inseri um CEP válido")
    @Issue("https://viacep.com.br/ws/91060900/json/")
    @Test
    public void consultaCEPValido(){
        given()
                .spec(requestSpecValido)
        .when()
                .get()
        .then()
                .spec(responseSpec)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas"+ File.separator + "ValidarCEPJsonSchemas.json"))
                .log().body();
    }

    @Feature("CEP INEXISTENTE")
    @DisplayName("Consulta CEP inexistente")
    @Description("O usuário inseri um CEP que não exista na base dos Correios")
    @Issue("https://viacep.com.br/ws/00000000/json/")
    @Test
    public void consultaCEPInexistente(){
        given()
                .spec(requestSpecInexistente)
        .when()
                .get()
        .then()
                .spec(responseSpec)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas"+ File.separator + "ErroCEPJsonSchemas.json"))
                .log().body();
    }
    @Feature("CEP INVÁLIDO")
    @DisplayName("Consulta CEP com formato inválido")
    @Description("O usuário inseri um CEP com formato inválido")
    @Issue("https://viacep.com.br/ws/12345/json/")
    @Test
    public void consultaCEPInvalido(){
        given()
                .spec(requestSpecInvalido)
        .when()
                .get()
        .then()
                .statusCode(400)
                .log().body();
    }

    @Feature("EXTRA")
    @DisplayName("Consulta letras")
    @Description("O usuário inseri umas letras estado, cidade e logradouro")
    @Issue("https://viacep.com.br/ws/RS/Gravatai/Barroso/json/")
    @Test
    public void consultaLetra(){
        given()
                .spec(requestSpecExtra)
        .when()
                .get()
        .then()
                .spec(responseSpec)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas"+ File.separator + "ValidarLetraJsonSchemas.json"))
                .log().body();
    }


}
