package support;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static support.Relatorio.configurarRelatorioExtent;
import static support.Relatorio.fecharRelatorio;

public class BaseTest extends GerenciadorDriver {

    private  static WebDriver driver;

    private String URL = "https://www.saucedemo.com/index.html";

    public static WebDriver pegarDriver(){

        driver = pegarDriver(Driver.CHROME);
        return driver;

    }

    @BeforeClass
    public void inicial(){
        configurarRelatorioExtent();
        pegarDriver().get(URL);
    }

    @AfterClass
    public void terminar(){
        fecharRelatorio();
        fecharDriver();
    }
}
