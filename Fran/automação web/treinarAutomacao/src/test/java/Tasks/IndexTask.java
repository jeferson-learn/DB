package Tasks;

import PageObjects.IndexPage;
import PageObjects.ListaFuncionalidadesPageObjects;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import support.Screenshot;
import support.Wait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static support.Report.extentTest;

public class IndexTask {

    private static WebDriver driver;
    private static Wait wait;
    private static IndexPage index;
    private static ListaFuncionalidadesPageObjects lista;

    public IndexTask(WebDriver driver){
        this.driver = driver;
        wait = new Wait(this.driver);
        index = new IndexPage(this.driver);
        lista = new ListaFuncionalidadesPageObjects(this.driver);
    }

    public void entrarAutomacao(){
        index.getAutomacaoWebButton().click();
        validarPaginaListaFuncionalidades();
    }

    public void validarPaginaListaFuncionalidades(){
        try{
//          wait.waitCarregarElement(lista.getBemVindoTextLabel());
            String text = lista.getBemVindoTextLabel().getText();
            assertEquals("Bem vindo ao Site de Automação do Batista.", text);
//            extentTest.log(Status.PASS, "Entrou botão 'automação web' com sucesso e a pagina está home.", Screenshot.screenshotBase64(driver));
            extentTest.log(Status.PASS, "Entrou botão 'automação web' com sucesso e a pagina está home.", Screenshot.screenshot(driver));
        }catch (Exception ex){
            // usa com comentario baixo sem erro
//            extentTest.log(Status.FAIL, "Entrou não botão 'automação web'.", Screenshot.screenshotBase64(driver));
        }
    }
}
