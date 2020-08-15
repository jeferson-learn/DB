package Tasks;

import PageObjects.CarrinhoPage;
import PageObjects.InformacaoPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import support.Esperas;
import support.TirarFoto;

import static org.testng.Assert.assertEquals;
import static support.Relatorio.extentTest;

public class CarrinhoTask {

    private WebDriver driver;
    private CarrinhoPage carrinho;
    private InformacaoPage informacao;
    private Esperas esperas;

    public CarrinhoTask(WebDriver driver){
        this.driver = driver;
        carrinho = new CarrinhoPage(driver);
        informacao = new InformacaoPage(driver);
        esperas = new Esperas(driver);
    }

    public void clicarCheckout(){
        carrinho.getCheckoutButton().click();
        validarPaginaInformacao();
    }

    public void validarPaginaInformacao(){
        try {
            esperas.esperaCarregarElemento(informacao.getCheckoutYourInformationTextLabel());
            String label = informacao.getCheckoutYourInformationTextLabel().getText();
            assertEquals("Checkout: Your Information", label);
            extentTest.log(Status.PASS, "A pagina carregada com sucesso: " + label, TirarFoto.tirarFotoBase64(driver));
        }catch (Exception ex){
            extentTest.log(Status.FAIL, "Não carregou a pagina", TirarFoto.tirarFotoBase64(driver));
        }
    }
}
