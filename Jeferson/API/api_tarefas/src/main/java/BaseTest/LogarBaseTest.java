package BaseTest;

import Models.LoginModel;
import Utils.EndPoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class LogarBaseTest extends EndPoints {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static Map<String, Object> loginObject;

    @BeforeAll
    public static void setUp(){

        loginObject = Utils.Maps.objectMap("session", new LoginModel(EMAIL, PASSWORD));

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH_SESSIONS)
                .setContentType(ContentType.JSON)
                .setBody(loginObject)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
