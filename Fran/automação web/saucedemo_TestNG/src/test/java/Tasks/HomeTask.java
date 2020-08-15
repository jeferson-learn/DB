package Tasks;

import PageObjects.HomePage;
import PageObjects.SelecionarProdutoPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import support.Esperas;
import support.TirarFoto;

import static org.testng.Assert.assertEquals;
import static support.Relatorio.extentTest;

public class HomeTask {
     private static WebDriver driver;
     private static HomePage home;
     private static SelecionarProdutoPage selecionarProduto;
     private static Esperas esperas;

     public HomeTask(WebDriver driver){
         this.driver = driver;
         home = new HomePage(this.driver);
         selecionarProduto = new SelecionarProdutoPage(this.driver);
         esperas = new Esperas(driver);
     }

     public void realizarLogin(String usuario, String senha){
         home.getUsuarioTextLabel().sendKeys(usuario);
         home.getSenhaTextLabel().sendKeys(senha);
         home.getLoginButton().click();
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
