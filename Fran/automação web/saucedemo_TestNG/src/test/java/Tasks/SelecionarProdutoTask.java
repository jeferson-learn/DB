package Tasks;

import PageObjects.CarrinhoPage;
import PageObjects.ProdutoPage;
import PageObjects.SelecionarProdutoPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import support.Esperas;
import support.TirarFoto;

import static org.testng.Assert.assertEquals;
import static support.Relatorio.extentTest;

public class SelecionarProdutoTask {
    private static WebDriver driver;
    private static SelecionarProdutoPage selecionarProdutoPage;
    private static ProdutoPage produtoPage;
    private static Esperas esperas;
    private static CarrinhoPage carrinho;

    public SelecionarProdutoTask(WebDriver driver){
        this.driver = driver;
        selecionarProdutoPage = new SelecionarProdutoPage(this.driver);
        produtoPage = new ProdutoPage(this.driver);
        esperas = new Esperas(this.driver);
        carrinho = new CarrinhoPage(this.driver);
    }

    public void escolherProduto(){
        selecionarProdutoPage.getImagemProdutoButton().click();
        validarPaginaProduto();
    }

    public void selecionarIconeCarrinho(){
        selecionarProdutoPage.getCarrinhosButton().click();
        validarPaginaCarrinho();
    }

    public void validarPaginaProduto(){
        try {
            esperas.esperaCarregarElemento(produtoPage.getSwagLabsTextLabel());
            String label = produtoPage.getSwagLabsTextLabel().getText();
            assertEquals("Swag Labs", label);
            extentTest.log(Status.PASS, "A pagina carregada com sucesso: " + label, TirarFoto.tirarFotoBase64(driver));
        }catch (Exception ex){
            extentTest.log(Status.FAIL, "Não carregou a pagina", TirarFoto.tirarFotoBase64(driver));
        }
    }

    public void validarPaginaCarrinho(){
        try {
            esperas.esperaCarregarElemento(carrinho.getYourCartTextLabel());
            String label = carrinho.getYourCartTextLabel().getText();
            assertEquals("Your Cart", label);
            extentTest.log(Status.PASS, "A pagina carregada com sucesso: " + label, TirarFoto.tirarFotoBase64(driver));
        }catch (Exception ex){
            extentTest.log(Status.FAIL, "Não carregou a pagina", TirarFoto.tirarFotoBase64(driver));

        }
    }
}
