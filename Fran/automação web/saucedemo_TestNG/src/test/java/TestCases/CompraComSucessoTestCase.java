package TestCases;

import Tasks.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.BaseTest;
import support.DataClass;
import support.TirarFoto;

import java.io.IOException;

import static support.Relatorio.extentRelatorio;
import static support.Relatorio.extentTest;

public class CompraComSucessoTestCase extends BaseTest {

    private WebDriver driver = this.pegarDriver();

    HomeTask home = new HomeTask(driver);
    SelecionarProdutoTask selecionarProduto = new SelecionarProdutoTask(driver);
    ProdutoTask produto = new ProdutoTask(driver);
    CarrinhoTask carrinho = new CarrinhoTask(driver);
    InformacaoTask informacao = new InformacaoTask(driver);
    OverviewTask overview = new OverviewTask(driver);

//    @Test(dataProvider = "getLogin")
    @Test(dataProvider = "login-users-csv", dataProviderClass = DataClass.class)
    public void realizarCompra(String usuario, String senha) throws IOException {
        try {
            extentTest = extentRelatorio.createTest("Compra com sucesso");
            home.realizarLogin(usuario, senha);
            selecionarProduto.escolherProduto();
            produto.adicionarProduto();
            selecionarProduto.selecionarIconeCarrinho();
            carrinho.clicarCheckout();
            informacao.informacoes();
            overview.overview();
        } catch (Exception e) {
            extentTest.log(Status.ERROR, e.getMessage(), TirarFoto.tirarFoto(driver));
        }
    }

//    @DataProvider
//    public Object [][] getLogin(){
//        return new Object[][] {{"standard_user","secret_sauce"}};
//    }
}
