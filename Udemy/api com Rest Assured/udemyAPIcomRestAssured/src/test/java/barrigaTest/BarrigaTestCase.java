package barrigaTest;

import Models.MovimentacaoModel;
import barrigaFW.BaseTest;
import io.restassured.specification.FilterableRequestSpecification;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import utils.DataUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BarrigaTestCase extends BaseTest {

    private static String CONTA_NOME = "Conta " + System.nanoTime();
    private static Integer CONTA_ID;
    private static Integer MOV_ID;

    @BeforeEach
    public void login(){

        Map<String, String> object = new HashMap<String, String>();
        object.put("email", "jefersonbarriga@hotmail.com");
        object.put("senha", "123456");

        String TOKEN =
                given()
                        .spec(requestSpec)
                        .body(object)
                .when()
                        .post("/signin")
                .then()
                        .log().body()
                        .statusCode(200)
                        .extract().path("token");

        requestSpec.header("Authorization", "JWT " + TOKEN);
    }

    @Test
    @Order(2)
    public void t02_deveIncluirContaComSucesso(){

        CONTA_ID =
        given()
                .spec(requestSpec)
                .body("{ \"nome\" : \""+CONTA_NOME+"\" }")
        .when()
                .post("/contas")
        .then()
                .log().body()
                .statusCode(201)
                .extract().path("id");
    }

    @Test
    @Order(3)
    public void t03_deveAlterarContaComSucesso(){

        given()
                .spec(requestSpec)
                .body("{ \"nome\" : \"" + CONTA_NOME + " alterar\" }")
                .pathParam("id", CONTA_ID)
        .when()
                .put("/contas/{id}")
        .then()
                .log().body()
                .statusCode(200)
                .body("nome", Matchers.is(CONTA_NOME + " alterar"));
    }

    @Test
    @Order(4)
    public void t04_naoDeveInserirContaMesmoNome(){

        given()
                .spec(requestSpec)
                .body("{ \"nome\" : \"" + CONTA_NOME + " alterar\" }")
        .when()
                .post("/contas")
        .then()
                .log().body()
                .statusCode(400)
                .body("error", Matchers.is("Já existe uma conta com esse nome!"))
        ;
    }

    @Test
    @Order(5)
    public void t05_deveInserirMovimentacaoSucesso(){

        MovimentacaoModel mov = getMovimentacaoValido();

        MOV_ID =
        given()
                .spec(requestSpec)
                .body(mov)
        .when()
                .post("/transacoes")
        .then()
                .log().body()
                .statusCode(201)
                .extract().path("id")
        ;
    }

    @Test
    @Order(6)
    public void t06_deveValidarCamposObrigatorioMovimentacao(){

        given()
                .spec(requestSpec)
                .body("{}")
        .when()
                .post("/transacoes")
        .then()
                .log().body()
                .statusCode(400)
                .body("$", Matchers.hasSize(8))
                .body("msg", Matchers.hasItems(
                        "Data da Movimentação é obrigatório",
                        "Data do pagamento é obrigatório",
                        "Descrição é obrigatório",
                        "Interessado é obrigatório",
                        "Valor é obrigatório",
                        "Valor deve ser um número",
                        "Conta é obrigatório",
                        "Situação é obrigatório"
                ))
        ;
    }

    @Test
    @Order(7)
    public void t07_naoDeveInserirMovimentacaoComDataFutura(){

        MovimentacaoModel mov = getMovimentacaoValido();
        mov.setData_transacao(DataUtils.getDataDiferencaDias(2));

        given()
                .spec(requestSpec)
                .body(mov)
        .when()
                .post("/transacoes")
        .then()
                .log().body()
                .statusCode(400)
                .body("$", Matchers.hasSize(1))
                .body("msg", Matchers.hasItem("Data da Movimentação deve ser menor ou igual à data atual"))
        ;
    }

    @Test
    @Order(8)
    public void t08_naoDeveRemoveContaComMovimentacao(){

        given()
                .spec(requestSpec)
                .pathParam("id", CONTA_ID)
        .when()
                .delete("/contas/{id}")
        .then()
                .log().body()
                .statusCode(500)
                .body("constraint", Matchers.is("transacoes_conta_id_foreign"))
        ;
    }

    @Test
    @Order(9)
    public void t09_deveCalcularSaldoContas(){

        given()
                .spec(requestSpec)
        .when()
                .get("/saldo")
        .then()
                .log().body()
                .statusCode(200)
                .body("find{ it.conta_id == "+CONTA_ID+"}.saldo", Matchers.is("100.00"))
        ;
    }

    @Test
    @Order(10)
    public void t10_deveRemoverMovimentacao(){

        given()
                .spec(requestSpec)
                .pathParam("id", MOV_ID)
        .when()
                .delete("/transacoes/{id}")
        .then()
                .log().body()
                .statusCode(204)
        ;
    }

    @Test
    @Order(11)
    public void t11_naoDeveAcessarAPISemToken(){
        FilterableRequestSpecification req = (FilterableRequestSpecification) requestSpec;
        req.removeHeader("Authorization");

        given()
                .spec(requestSpec)
        .when()
                .get("/contas")
        .then()
                .log().body()
                .statusCode(401);
    }

    private MovimentacaoModel getMovimentacaoValido(){
        MovimentacaoModel mov = new MovimentacaoModel();
        mov.setConta_id(CONTA_ID);
//        mov.setUsuario_id();
        mov.setDescricao("Descricao de movimentacao");
        mov.setEnvolvido("Envolvido na movimentacao");
        mov.setTipo("REC");
        mov.setData_transacao(DataUtils.getDataDiferencaDias(-1));
        mov.setData_pagamento(DataUtils.getDataDiferencaDias(5));
        mov.setValor(100f);
        mov.setStatus(true);
        return mov;
    }
}
