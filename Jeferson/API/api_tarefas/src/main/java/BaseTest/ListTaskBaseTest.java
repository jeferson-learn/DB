package BaseTest;

import Utils.EndPoints;
import Utils.ObjectsUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ListTaskBaseTest extends EndPoints {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeEach
    public void setUp(){
        String token = ObjectsUtils.getPropertiesData("dadosInformacao", "token");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH_TASKS)
                .addHeader("Authorization", token)
                .setContentType(ContentType.JSON)
                .build();
        System.out.println(token);
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

}
