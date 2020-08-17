package XML;

import io.restassured.internal.path.xml.NodeImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class userXMLTest {

    @Test
    public void devoTrabalharComXML(){
        given()
        .when()
                .get("https://restapi.wcaquino.me/usersXML/3")
        .then()
                .statusCode(200)
                .rootPath("user")
                .body("name", is("Ana Julia"))
                .body("@id", is("3"))

                .rootPath("user.filhos")
                .body("name.size()", is(2))

                .detachRootPath("filhos")
                .body("filhos.name[0]", is("Zezinho"))
                .body("filhos.name[1]", is("Luizinho"))
                .appendRootPath("filhos")
                .body("name", hasItem("Luizinho"))
                .body("name", hasItems("Zezinho","Luizinho"))
        ;
    }

    @Test
    public void devoFazerPesquisasAvancadaXML(){
        given()
        .when()
                .get("https://restapi.wcaquino.me/usersXML")
        .then()
                .statusCode(200)
                .body("users.user.size()", is(3))
                .body("users.user.findAll { it.age.toInteger() <= 25 }.size()", is(2))
                .body("users.user.@id", hasItems("1","2","3"))
                .body("users.user.find { it.age == 25 }.name", is("Maria Joaquina"))
                .body("users.user.findAll { it.name.toString().contains('n') }.name", hasItems("Maria Joaquina", "Ana Julia"))
                .body("users.user.salary.find { it != null }", is("1234.5678"))
                .body("users.user.salary.find { it != null }.toDouble()", is(1234.5678d))
                .body("users.user.age.collect { it.toInteger() * 2 }", hasItems(40, 50, 60))
                .body("users.user.name.findAll { it.toString().startsWith('Maria') }.collect { it.toString().toUpperCase() }", is("MARIA JOAQUINA"))
        ;
    }

    @Test
    public void devoFazerPesquisasAvancadaXMLEJava(){
//        String nome =
//        Object path =
//        ArrayList<String> nomes =
        ArrayList<NodeImpl> nomes1 =
        given()
        .when()
                .get("https://restapi.wcaquino.me/usersXML")
        .then()
                .statusCode(200)
//                .extract().path("users.user.name.findAll { it.toString().startsWith('Maria') }") *String nome*
                .extract().path("users.user.name.findAll { it.toString().contains('n')}")
        ;

//        Assert.assertEquals("Maria Joaquina".toUpperCase(), nome.toUpperCase());
//        System.out.println(path);
//        System.out.println(nomes);
//        Assert.assertEquals(2, nomes.size());
        Assert.assertEquals("Maria Joaquina".toUpperCase(), nomes1.get(0).toString().toUpperCase());
//        Assert.assertTrue("ANA JULIA", equalsIgnoreCase(nomes1.get(1).toString()));

    }

    @Test
    public void devoFazerPesquisasAvancadaComPath(){
                given()
                .when()
                        .get("https://restapi.wcaquino.me/usersXML")
                .then()
                        .statusCode(200)
                        .body(hasXPath("count(/users/user)", is("3")))
                        .body(hasXPath("/users/user[@id = '1']"))
                        .body(hasXPath("//user[@id = '2']"))
                        .body(hasXPath("//name[text() = 'Luizinho']/../../name", is("Ana Julia")))
                ;
    }
}
