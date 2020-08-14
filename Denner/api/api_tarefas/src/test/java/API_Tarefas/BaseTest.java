package API_Tarefas;

import Models.CriarUsuarioModel;
import Models.LoginModel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public static String token;
    public static String id;
    public static final CriarUsuarioModel criarUsuarioModel = new CriarUsuarioModel();
    public static final LoginModel loginModel = new LoginModel();
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeEach
    public void setUp(){

        JSONObject criandoJson = new JSONObject();
        criandoJson.put("title", "API");
        criandoJson.put("description", "Testando api do tarefa");
        criandoJson.put("deadline", "");
        criandoJson.put("done", false);

        JSONObject editandoJson = new JSONObject();
        editandoJson.put("title", "API 2");
        editandoJson.put("description", "Testando api do tarefa 2");
        editandoJson.put("done", true);

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }
}
