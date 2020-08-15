package Tasks;

import PageObjects.FinishPage;
import PageObjects.HomePage;
import PageObjects.OverviewPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Esperas;
import support.TirarFoto;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static support.Relatorio.extentTest;

public class OverviewTask {

    private WebDriver driver;
    private OverviewPage overview;
    private Esperas esperas;
    private FinishPage finish;
    private HomePage home;

    public OverviewTask(WebDriver driver){
        this.driver = driver;
        overview = new OverviewPage(driver);
        esperas = new Esperas(driver);
        finish = new FinishPage(driver);
        home = new HomePage(driver);
    }

    public void overview(){
        overview.getFinishButton().click();
        validarPaginaFinish();
        overview.getMenuButton().click();
        esperas.esperaCarregarElemento(overview.getLogoutButton());
        overview.getLogoutButton().click();
        validarPaginaLogin();
    }

    public void validarPaginaFinish(){
        try{
            esperas.esperaCarregarElemento(finish.getFinishTextLabel());
            String label = finish.getFinishTextLabel().getText();
            assertEquals("Finish", label);
            extentTest.log(Status.PASS, "A pagina carregada com sucesso: " + label, TirarFoto.tirarFotoBase64(driver));
        }catch (Exception ex){
            extentTest.log(Status.FAIL, "Não carregou a pagina", TirarFoto.tirarFotoBase64(driver));
        }
    }

    public void validarPaginaLogin(){
        try{
            //esperas.esperaCarregarElemento(home.getUsuarioTextLabel());
            esperas.esperaVisibilidadeDoElemento(By.id("user-name"));
            boolean campousuario = home.getUsuarioTextLabel().isDisplayed();
            assertTrue(campousuario);
//            assertTrue(home.getUsuarioTextLabel().isDisplayed());
            extentTest.log(Status.PASS, "Logout efetuado", TirarFoto.tirarFotoBase64(driver));
        }catch (Exception ex){
            extentTest.log(Status.FAIL, "Logout nao realizado com sucesso", TirarFoto.tirarFotoBase64(driver));
        }
    }

}
