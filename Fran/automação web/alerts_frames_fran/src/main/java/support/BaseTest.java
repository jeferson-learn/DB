package support;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static support.Report.closeReport;
import static support.Report.configurarReportExtent;

public class BaseTest extends GerenciadorDriver{

    private static WebDriver driver;

    private String URL = "http://testpages.herokuapp.com/styled/index.html";

    public static WebDriver getDriver() {
        driver = getDriver(Drivers.CHROME);
        return driver;
    }

    @BeforeClass
    public void setUp() {
        configurarReportExtent();
        getDriver().get(URL);
    }

    @AfterClass
    public void tearDown(){
        closeReport();
        closeDriver();
    }
}