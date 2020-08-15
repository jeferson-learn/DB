package TestCases;

import Tasks.HomeAlertsJavaScriptTask;
import Tasks.HomeTask;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import support.BaseTest;
import support.Screenshot;

import static support.Report.*;

public class AlertsJavaScriptTestCase extends BaseTest {

    private static WebDriver driver = getDriver();
    HomeTask home = new HomeTask(driver);
    HomeAlertsJavaScriptTask homeAlerts = new HomeAlertsJavaScriptTask(driver);


    @Test
    public void alertsJavaScriptTest() throws InterruptedException {
        try{
        extentTest = extentReports.createTest("Teste Alerts JavaScritp");
        home.entrarAlertsJavaScript();
//        homeAlerts.showAlertBox();
        homeAlerts.showConfirmBoxOk();
        homeAlerts.showConfirmBoxCancel();
        homeAlerts.showPromptBox();
    }catch(Exception e ){

            extentTest.log(Status.ERROR, e.getMessage(), Screenshot.screenshotBase64(driver));


        }
    }

}
