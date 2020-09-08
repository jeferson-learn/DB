package barrigaFW;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest extends EndPoint{

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    @BeforeEach
    public void setup(){

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
//                .setBasePath(BASE_PORT8)
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

    }
}
