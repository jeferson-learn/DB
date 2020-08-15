package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Report {

    private static final String CAMINHO_RELATORIO = System.getProperty("user.dir") + File.separator + "Relatorio";
    public static WebDriver driver;
    public static ExtentHtmlReporter htmlReport;
    public static ExtentReports extentReport;
    public static ExtentTest extentTest;

    public static void configurarReportExtent(){

        CriarPasta.criarRelatorioPasta(CAMINHO_RELATORIO);

        htmlReport = new ExtentHtmlReporter(CAMINHO_RELATORIO + File.separator + "MyReport.html");

        htmlReport.config().setDocumentTitle("AUTOMAÇÃO");
        htmlReport.config().setReportName("Criar usuario com sucesso");
        htmlReport.config().setEncoding("UTF-8");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlReport.config().setJS("$('.brand-logo').html('<img src=\\\"https://i.imgur.com/qDYwkD2.png\\\" class=\\\"db-logo\\\"/>');");
        htmlReport.config().setCSS(".nav-wrapper { background-color: #1E317A !important; } .brand-logo { background-color: #1E317A !important; padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 { background-color: #1E317A !important; color: #FFF !important;  }");

        extentReport = new ExtentReports();

        extentReport.attachReporter(htmlReport);
    }

    public static void closeReport(){

        extentReport.flush();

        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

}
