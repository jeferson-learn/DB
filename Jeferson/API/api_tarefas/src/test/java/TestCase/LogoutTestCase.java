package TestCase;

import BaseTest.LogarBaseTest;
import Utils.ObjectsUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class LogoutTestCase extends LogarBaseTest {

    @Test
    public void logout(){
        String token = ObjectsUtils.getPropertiesData("dadosInformacao", "token");
        given()
                .spec(requestSpec)
        .when()
                .delete("/"+token)
        .then()
                .statusCode(204);
    }

}
