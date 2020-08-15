package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public static RequestSpecification requestSpecValido;
    public static RequestSpecification requestSpecInexistente;
    public static RequestSpecification requestSpecInvalido;
    public static RequestSpecification requestSpecExtra;
    public static ResponseSpecification responseSpec;

    @BeforeEach
    public void setUp() {
        requestSpecValido = new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br/ws")
                .setBasePath("/91060900/json/")
                .build();

        requestSpecInexistente = new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br/ws")
                .setBasePath("/00000000/json/")
                .build();

        requestSpecInvalido = new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br/ws")
                .setBasePath("/12345/json/")
                .build();

        requestSpecExtra = new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br/ws")
                .setBasePath("/RS/Gravatai/Barroso/json/")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

}
