package TestCase;

import BaseTest.LoginBaseTest;
import Utils.ObjectsUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class LoginTestCase extends LoginBaseTest {

    @Test
    public void login(){
        String token =
        given()
                .log().all()
                .spec(requestSpec)
        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpec)
                .extract().path("data.attributes.auth-token");

        ObjectsUtils.setPropertiesData("dadosInformacao", "token", token);
    }

    public void logout(){
        String token = ObjectsUtils.getPropertiesData("dadosInformacao", "token");
        given()
                .log().all()
                .spec(requestSpec)
        .when()
                .delete("/"+token)
        .then()
                .log().all()
                .statusCode(204);
        System.out.println("sucesso sair do login");
    }
}
