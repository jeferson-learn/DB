package TestCases;

import Tasks.IndexTask;
import Tasks.ListaFuncionalidadesTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import support.BaseTest;

public class CriarUsuarioTestCase extends BaseTest {

    private static WebDriver driver = getDriver();

    IndexTask index = new IndexTask(driver);
    ListaFuncionalidadesTask lista = new ListaFuncionalidadesTask(driver);

    @Test
    public void criarUsuarioComSucesso() throws InterruptedException {
        index.entrarAutomacao();
        lista.criarUsuario();
        Thread.sleep(2000);
    }
}
