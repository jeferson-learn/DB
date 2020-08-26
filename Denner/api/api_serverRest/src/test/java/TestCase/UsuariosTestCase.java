package TestCase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class UsuariosTestCase {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeEach
    public void setUp(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000")
                .setBasePath("/usuarios")
                .setContentType(ContentType.JSON)
                .build();
    }

}
