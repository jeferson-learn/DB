package Tasks;

import PageObjects.InformacaoPage;
import PageObjects.OverviewPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import support.Esperas;
import support.GeradorFakers;
import support.TirarFoto;

import static org.testng.Assert.assertEquals;
import static support.Relatorio.extentTest;

public class InformacaoTask {

    private WebDriver driver;
    private InformacaoPage informacao;
    private Esperas esperas;
    private OverviewPage overview;
    private GeradorFakers faker = new GeradorFakers();

    public InformacaoTask(WebDriver driver){
        this.driver = driver;
        informacao = new InformacaoPage(driver);
        esperas = new Esperas(driver);
        overview = new OverviewPage(driver);
    }

    public void informacoes(){
        informacao.getFirstNameTextLabel().sendKeys(faker.getPrimeiroNome());
        informacao.getLastNameTextLabel().sendKeys(faker.getSobreNome());
        informacao.getPostalCodeTextLabel().sendKeys(faker.getPostal());
        informacao.getContinueButton().click();
        validarPaginaCheckoutOverview();
    }

    public void validarPaginaCheckoutOverview(){
        try{
            esperas.esperaCarregarElemento(overview.getCheckoutOverviewTextLabel());
            String label = overview.getCheckoutOverviewTextLabel().getText();
            assertEquals("Checkout: Overview", label);
            extentTest.log(Status.PASS, "A pagina carregada com sucesso: " + label, TirarFoto.tirarFotoBase64(driver));
        }catch (Exception ex){
            extentTest.log(Status.FAIL, "Nao carregou a pagina", TirarFoto.tirarFotoBase64(driver));
        }
    }
}
