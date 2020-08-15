package restAssuredBasico;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class OlaMundo {

    @Test
    public void testOlaMundo(){
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me:80/ola");
        assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        assertTrue(response.statusCode() == 200);
        assertTrue("O status code deveria ser 200",response.statusCode() == 200);
        Assert.assertEquals(200, response.statusCode());

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

        System.out.println(response.getBody().asString());

    }

    @Test
    public void devoConhecerOutrasFormasRestAssured(){
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me:80/ola");
        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

        get("http://restapi.wcaquino.me:80/ola").then().statusCode(200);

        System.out.println(response.getBody().asString());

        given()
        .when()
                .get("http://restapi.wcaquino.me:80/ola")
        .then()
                .statusCode(200);
    }

    @Test
    public void devoConhecerMatcherHamcrest(){
        assertThat("Jef", is("Jef"));
        assertThat(27, is(27));
        assertThat(11, isA(Integer.class));
        assertThat(11d, isA(Double.class));
        assertThat(11d, greaterThan(10d)); // maior do que
        assertThat(11d, lessThan(12d)); // menor do que

        List<Integer> impares = Arrays.asList(1,3,5,7,9);
        assertThat(impares, hasSize(5)); // Quantos tamanho tem
        assertThat(impares, contains(1,3,5,7,9)); // igual array tem
        assertThat(impares, containsInAnyOrder(9,7,5,3,1)); // igual numero tem array, livre ordem
        assertThat(impares, hasItem(5)); // valor tem dentro array
        assertThat(impares, hasItems(5,9,1)); // valores tem dentro array

        assertThat("Jef", is(not("Lopes"))); // 'Jef' nao é 'Lopes', certo
        assertThat("Jef", not("Lopes"));

        assertThat("Thaviny", anyOf(is("Jef"), is("Thaviny"))); // certo se Jef ou Thaviny
//        assertThat("Fulano", anyOf(is("Jef"), is("Thaviny"))); // Fulano nao tem dentro 'Jef' ou 'Thaviny' erro

        assertThat("Jeferson", allOf(startsWith("Jef")));
        assertThat("Jeferson", allOf(endsWith("son")));
        assertThat("Jeferson", allOf(containsString("ers")));
        assertThat("Jeferson Lopes", allOf(startsWith("Jef"),endsWith("pes"),containsString("ers")));
    }

    @Test
    public void devoValidarBody(){
        given()
        .when()
                .get("http://restapi.wcaquino.me/ola")
        .then()
                .statusCode(200)
                .body(is("Ola Mundo!"))
                .body(containsString("Mundo"))
                .body(is(not(nullValue())));
    }

}
