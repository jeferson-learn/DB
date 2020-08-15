package Tasks;

import PageObjects.ProdutoPage;
import PageObjects.SelecionarProdutoPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import support.Esperas;
import support.TirarFoto;

import static org.testng.Assert.assertEquals;
import static support.Relatorio.extentTest;

public class ProdutoTask {
    private static WebDriver driver;
    private static ProdutoPage produtoPage;
    private static SelecionarProdutoPage selecionarProduto;
    private static Esperas esperas;

    public ProdutoTask(WebDriver driver){
        this.driver = driver;
        produtoPage = new ProdutoPage(driver);
        selecionarProduto = new SelecionarProdutoPage(driver);
        esperas = new Esperas(driver);
    }

    public void adicionarProduto(){
        produtoPage.getAddToCartButton().click();
        produtoPage.getBackButton().click();
        validarPaginaHome();
    }

    public void validarPaginaHome(){
        try{
            esperas.esperaCarregarElemento(selecionarProduto.getProductsTextLabel());
            String label = selecionarProduto.getProductsTextLabel().getText();
            assertEquals("Products", label);
            extentTest.log(Status.PASS, "Página inicial carregada com sucesso: " + label, TirarFoto.tirarFotoBase64(driver));
        }catch (Exception ex){
            extentTest.log(Status.FAIL, "Não carregou a página de produtos", TirarFoto.tirarFotoBase64(driver));
        }
    }
}
