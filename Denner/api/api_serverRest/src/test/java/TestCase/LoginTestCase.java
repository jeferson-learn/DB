package TestCase;

import BaseTest.LoginBaseTest;
import Models.LoginModel;
import Utils.ObjectJson;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginTestCase extends LoginBaseTest {

    @Test
    public void login(){

//        Map<String, String> createLogin = new HashMap<String, String>();
//        createLogin.put("email", "jeferson1@teste.com");
//        createLogin.put("email", "fulano@qa.com");
//        createLogin.put("password", "123456");
//        createLogin.put("password", "teste");

        given()
                .log().body()
                .spec(requestSpec)
                .body(ObjectJson.loginExisteJsonObject())
        .when()
                .post()
        .then()
                .log().body()
                .spec(responseSpec);
    }

}
