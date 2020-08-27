package TestCase;

import BaseTest.LoginBaseTest;
import Utils.ObjectsUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LogoutTestCase extends LoginBaseTest {

    @Test
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
    }

}
