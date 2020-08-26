package TestCase;

import Models.LoginModel;
import Utils.EndPoint;
import Utils.Maps;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@JsonPropertyOrder({"email","password"})
public class LoginTestCase extends EndPoint {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    public static Map<String, Object> objectMap;
    public static LoginModel loginModel;

    @BeforeEach
    public void setUp(){
//        objectMap = Maps.mapObject("login", new LoginModel(EMAIL,PASSWORD));

        Map<String, String> createLogin = new HashMap<String, String>();
        createLogin.put("email", "jeferson1@teste.com");
        createLogin.put("password", "123456");

        JSONObject login = new JSONObject();
        login.put("email", "jeferson1@teste.com");
        login.put("password", "123456");

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000")
                .setBasePath("/login")
                .setContentType(ContentType.JSON)
//                .setBody(objectMap.toString()) // MAP OBJECT
//                .setBody(Maps.mapObjectString().toString()) // MAP STRING
//                .setBody(createLogin.toString()) // MAP PUT
                .setBody(login.toString()) // JSONObject PUT
//                .addHeader("authorization", "Bearer")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void login(){
//        Map<String, String> createLogin = new HashMap<String, String>();
//        createLogin.put("email", "jeferson1@teste.com");
//        createLogin.put("password", "123456");
        given()
                .log().all()
                .spec(requestSpec)
//                .body(createLogin.toString())
        .when()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .spec(responseSpec)
        ;
    }

}
