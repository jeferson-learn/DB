package TestCase;

import BaseTest.LoginBaseTest;
import Models.LoginModel;
import Utils.ObjectJson;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginTestCase extends LoginBaseTest {

    @Feature("API de Serverest 'Login'")
    @DisplayName("LOGIN")
    @Description("Acesso login")
    @Issue("http://localhost:3000/login")
    @Test
    public void login() throws IOException {

//        Map<String, String> createLogin = new HashMap<String, String>();
//        createLogin.put("email", "jeferson1@teste.com");
//        createLogin.put("email", "fulano@qa.com");
//        createLogin.put("password", "123456");
//        createLogin.put("password", "teste");

        System.out.println("Login");

        String TOKEN =
        given()
                .spec(requestSpec)
                .body(ObjectJson.loginTest())
//                .body(ObjectJson.loginNewJsonObject())
        .when()
                .post()
        .then()
                .log().body()
                .spec(responseSpec)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "LoginUsuarioJsonSchemas.json"))
                .extract().path("authorization");

        Utils.ObjectsUtils.setPropertiesData("dadosUsuario", "TOKEN", TOKEN);
    }

}
