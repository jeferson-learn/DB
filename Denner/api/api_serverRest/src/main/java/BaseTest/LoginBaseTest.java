package BaseTest;

import Models.LoginModel;
import Utils.EndPoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class LoginBaseTest extends EndPoint {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private LoginModel loginModel = new LoginModel(EMAILEXISTE,PASSWORDEXISTE);
//    private LoginModel loginModel = new LoginModel();

    @BeforeEach
    public void setUp(){
        requestLogin();
        responseLogin();
    }

    public void requestLogin() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_LOGIN)
//                .setBody(loginModel)
                .setContentType(ContentType.JSON)
                .build();
    }

    public void responseLogin() {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }
}