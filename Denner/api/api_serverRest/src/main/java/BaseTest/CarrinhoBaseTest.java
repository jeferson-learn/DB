package BaseTest;

import Utils.EndPoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class CarrinhoBaseTest extends EndPoint {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeEach
    public void setUp(){
        request();
        response();
    }

    public void request() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_CARRINHOS)
                .setContentType(ContentType.JSON)
                .build();
    }

    public void response() {
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

}
