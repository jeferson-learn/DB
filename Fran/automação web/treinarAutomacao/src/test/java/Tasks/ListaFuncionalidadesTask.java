package Tasks;

import PageObjects.ListaFuncionalidadesPageObjects;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import support.Report;
import support.Screenshot;
import support.Wait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static support.Report.*;

public class ListaFuncionalidadesTask {

    private static Wait wait;
    private static WebDriver driver;
    private static ListaFuncionalidadesPageObjects lista;

    public ListaFuncionalidadesTask(WebDriver driver){
        this.driver = driver;
        wait = new Wait(this.driver);
        lista = new ListaFuncionalidadesPageObjects(this.driver);
    }

    public void criarUsuario(){
        wait.waitCarregarElement(lista.getMenuFormularioButton());
        lista.getMenuFormularioButton().click();

        wait.waitCarregarElement(lista.getMenuFormularioCriarUsuarioButton());
        lista.getMenuFormularioCriarUsuarioButton().click();

//        String text = lista.getNovoUsuarioTextLabel().getText();
//        assertEquals("Novo Usuário!!", text);
        validarPaginaNovoUsuario();

        lista.getNameTextLabel().sendKeys("Jeferson");
        lista.getLastNameTextLabel().sendKeys("Souza");
        lista.getEmailTextLabel().sendKeys("jeferson@com.br");
        lista.getEnderecoTextLabel().sendKeys("Ip, 650");
        lista.getUniversidadeTextLabel().sendKeys("FEDERAL");
        lista.getProfissaoTextLabel().sendKeys("Automacao");
        lista.getGeneroTextLabel().sendKeys("Masculino");
        lista.getIdadeTextLabel().sendKeys("55");
        lista.getCriarButton().click();

        String text1 = lista.getUsuarioCriadoComSucessoTextLabel().getText();
        assertEquals("Usuário Criado com sucesso", text1);

        lista.getVoltarButton().click();
        wait.waitCarregarElement(lista.getVoltarHomeButton());
        lista.getVoltarHomeButton().click();
    }

    public void validarPaginaNovoUsuario(){
        try{
            String text = lista.getNovoUsuarioTextLabel().getText();
            assertEquals("Novo Usuário!!", text);
            extentTest.log(Status.PASS, "Abriu a pagina novo usuario.", Screenshot.screenshotBase64(driver));
        }catch (Exception ex){
            // usa com comentario baixo sem erro
//            extentTest.log(Status.FAIL, "Não abriu a pagina novo usuario.", Screenshot.screenshotBase64(driver));
        }
    }
}
