package BaseTest;

import Models.ProdutoModel;
import Utils.EndPoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class ProdutoBaseTest extends EndPoint {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
//    private ProdutoModel produtoModel = new ProdutoModel();

    @BeforeEach
    public void setUp(){
        request();
        response();
    }

    public void request() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_PRODUTOS)
                .setContentType(ContentType.JSON)
//                .setBody(produtoModel)
                .build();
    }

    public void response() {
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
