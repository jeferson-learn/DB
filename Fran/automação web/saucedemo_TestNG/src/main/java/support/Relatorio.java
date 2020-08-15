package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Relatorio {

    private static final String CAMINHO_RELATORIO = System.getProperty("user.dir") + File.separator + "Relatorio";
    public static WebDriver driver;
    public static ExtentHtmlReporter htmlRelatorio;
    public static ExtentReports extentRelatorio;
    public static ExtentTest extentTest;

    public static void configurarRelatorioExtent(){

        CriarPasta.criarRelatorioPasta(CAMINHO_RELATORIO);

        htmlRelatorio = new ExtentHtmlReporter(CAMINHO_RELATORIO + File.separator + "MeuRelatorio.html");
        htmlRelatorio.config().setDocumentTitle("Relatorio de Execucao de Automação");
        htmlRelatorio.config().setReportName("Relatorio de Execucao dos Testes");
        htmlRelatorio.config().setTheme(Theme.DARK);
        htmlRelatorio.config().setEncoding("UTF-8");
        htmlRelatorio.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlRelatorio.config().setCSS(".nav-wrapper { background-color: #1E317A !important; } .brand-logo { background-color: #1E317A !important; padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 { background-color: #1E317A !important; color: #FFF !important;  }");
        htmlRelatorio.config().setJS("$('.brand-logo').html('<img src=\\\"https://i.imgur.com/qDYwkD2.png\\\" class=\\\"db-logo\\\"/>');");

        extentRelatorio = new ExtentReports();

        extentRelatorio.attachReporter(htmlRelatorio);

    }

    public static void fecharRelatorio(){

        extentRelatorio.flush();

        if (driver!=null){
            driver.quit();
            driver = null;
        }

    }

}
