package support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static support.Report.closeReport;
import static support.Report.configurarReportExtent;

public class BaseTest extends GerenciadorDriver {

    private static WebDriver driver;

    private String URL = "https://automacaocombatista.herokuapp.com/home/index";

    public static WebDriver getDriver() {
        driver = getDriver(Drivers.CHROME);
        return driver;
    }

    @BeforeEach
    public void inicial(){
        configurarReportExtent();
        getDriver().get(URL);
    }

    @AfterEach
    public void terminar(){
        closeReport();
        closeDriver();
    }

}
