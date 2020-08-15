package jsonNivel;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class UsersNivel {

    @Test
    public void deveVerificarPrimeiroNivel(){
        given()

        .when()
                .get("http://restapi.wcaquino.me/users/1")
        .then()
                .statusCode(200)
                .body("id",is(1))
                .body("name",containsString("da"))
                .body("age", greaterThan(18))
//                .body("salary",is(1234.5678))
        ;
    }

    @Test
    public void deveVerificarPrimeiroNivelOutrasFormas(){
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/users/1");
//        Path
        System.out.println(response.path("id"));
        System.out.println(response.path("name"));
        System.out.println(response.path("age"));
        System.out.println(response.path("salary"));

        assertEquals(new Integer(1), response.path("id"));
        assertEquals(new Integer(1), response.path("%s","id"));

        assertEquals("João da Silva", response.path("name"));
        assertEquals(new Integer(30), response.path("age"));
//        assertEquals(new double(1234.5678), response.path("salary"));

//        JSONpath
        JsonPath jpath = new JsonPath(response.asString());
        assertEquals(1, jpath.getInt("id"));
        assertEquals("João da Silva", jpath.getString("name"));
        assertEquals(30, jpath.getInt("age"));
//        assertEquals(1234.5678, jpath.getInt("salary"));

//        from
        int id = JsonPath.from(response.asString()).getInt("id");
        assertEquals(1, id);

        String nome = JsonPath.from(response.asString()).getString("name");
        assertEquals("João da Silva", nome);

        int idade = JsonPath.from(response.asString()).getInt("age");
        assertEquals(30, idade);

        double salario = JsonPath.from(response.asString()).getDouble("salary");
        System.out.println(salario);
//        assertEquals(1234.5677, salario);
    }

    @Test
    public void deveVerificarSegundoNivel(){
        given()
        .when()
                .get("http://restapi.wcaquino.me/users/2")
        .then()
                .statusCode(200)
                .body("name", is("Maria Joaquina"))
                .body("endereco.rua", is("Rua dos bobos"))
                .body("endereco.numero", is(0));
    }

    @Test
    public void deveVerificarLista(){
        given()
        .when()
                .get("http://restapi.wcaquino.me/users/3")
        .then()
                .statusCode(200)
                .body("name", containsString("Ana"))
                .body("filhos", hasSize(2))
                .body("filhos[0].name", is("Zezinho"))
                .body("filhos[1].name", is("Luizinho"))
                .body("filhos.name", hasItem("Luizinho"))
                .body("filhos.name", hasItems("Luizinho", "Zezinho"))
        ;
    }

    @Test
    public void deveRetornarErroUsuarioInexistente(){
        given()
        .when()
                .get("http://restapi.wcaquino.me/users/4")
        .then()
                .statusCode(404)
                .body("error", is("Usuário inexistente"))
        ;
    }

    @Test
    public void deveVerificarListaRaiz(){
        given()
        .when()
                .get("http://restapi.wcaquino.me/users")
        .then()
                .statusCode(200)
                .body("$", hasSize(3)) // ou .body("", hasSize(3))
                .body("name", hasItems("João da Silva", "Maria Joaquina", "Ana Júlia"))
                .body("age[1]", is(25))
                .body("filhos.name", hasItem(Arrays.asList("Zezinho", "Luizinho")))
                .body("endereco.rua", hasItem("Rua dos bobos"))
                .body("endereco.numero", hasItem(0))
                .body("salary", contains(1234.5678f, 2500, null))
        ;
    }

    @Test
    public void deveVerificarAvancadas(){
        given()
        .when()
                .get("http://restapi.wcaquino.me/users")
        .then()
                .statusCode(200)
                .body("$", hasSize(3))
                .body("age.findAll { it <= 25 }.size()", is(2))
                .body("age.findAll { it <= 25 && it > 20 }.size()", is(1))
                .body("findAll { it.age <= 25 && it.age > 20 }.name", hasItem("Maria Joaquina"))
                .body("findAll { it.age <= 25 }[0].name", is("Maria Joaquina"))
                .body("findAll { it.age <= 25 }[-1].name", is("Ana Júlia"))
                .body("find { it.age <= 25 }.name", is("Maria Joaquina"))
                .body("findAll { it.name.contains('n') }.name", hasItems( "Ana Júlia", "Maria Joaquina"))
                .body("findAll { it.name.length() > 10 }.name", hasItems( "João da Silva", "Maria Joaquina"))
                .body("name.collect { it.toUpperCase() }", hasItem( "MARIA JOAQUINA"))
                .body("name.findAll { it.startsWith('Maria') }.collect{ it.toUpperCase() }", hasItem( "MARIA JOAQUINA"))
                .body("name.findAll { it.startsWith('Maria') }.collect{ it.toUpperCase() }.toArray()", allOf(arrayContaining("MARIA JOAQUINA"), arrayWithSize(1)))
                .body("age.collect { it * 2 }", hasItems(60,50,40))
                .body("id.max()", is(3))
                .body("salary.min()", is(1234.5678f))
                .body("salary.findAll { it != null }.sum()", is(closeTo(3734.5678f, 0.001)))
                .body("salary.findAll { it != null }.sum()", allOf(greaterThan(3000d), lessThan(5000d)))
        ;
    }

    @Test
    public void deveUnirJsonPathComJAVA(){
        ArrayList<String> nomes =
        given()
        .when()
                .get("http://restapi.wcaquino.me/users")
        .then()
                .statusCode(200)
                .extract().path("name.findAll { it.startsWith('Maria') }")
        ;

        System.out.println(nomes.get(0));

        Assert.assertEquals(1, nomes.size());
        Assert.assertTrue(nomes.get(0).equalsIgnoreCase("MaRiA Joaquina "));
        Assert.assertEquals(nomes.get(0).toUpperCase(), "maria joaquina".toUpperCase());
    }



}
