package BaseTest;

import Models.CreateTaskModel;
import Utils.EndPoints;
import Utils.Maps;
import Utils.ObjectsUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;

public class CreateTaskBaseTest extends EndPoints {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static Map<String, Object> objectMap;

    @BeforeEach
    public void setUp(){
        String token = ObjectsUtils.getPropertiesData("dadosInformacao", "token");
        objectMap = Maps.objectMap("task", new CreateTaskModel());
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH_TASKS)
                .addHeader("Authorization", token)
                .setContentType(ContentType.JSON)
                .setBody(objectMap)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();
    }

}
