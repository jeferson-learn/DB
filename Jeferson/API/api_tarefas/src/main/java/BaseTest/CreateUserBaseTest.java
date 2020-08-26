package BaseTest;

import Models.CreateUserModel;
import Utils.EndPoints;
import Utils.Maps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import sun.plugin.extension.ExtensionUtils;

import java.util.HashMap;
import java.util.Map;

public class CreateUserBaseTest extends EndPoints {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static Map<String, Object> createUserObject;

    @BeforeAll
    public static void setUp(){
        Map<String, String> createUser = new HashMap<String, String>();
//        JSONObject createUser = new JSONObject();
//        createUser.put("email", "testes1@testes.com");
//        createUser.put("password", "123456");
//        createUser.put("password_confirmation", "123456");
        createUserObject = Utils.Maps.objectMap("user", new CreateUserModel());

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH_USER)
                .setContentType(ContentType.JSON)
//                .setBody(createUser.toString())
                .setBody(createUserObject.toString())
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();

    }

}
