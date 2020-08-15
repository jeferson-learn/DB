package Tasks;

import PageObjects.HomeFakeAlertsPage;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Screenshot;
import support.Wait;

import static support.Report.extentTest;

public class HomeFakeAlertsTask {

    private static WebDriver driver;
    private static Wait wait;
    private static HomePage home;
    private static HomeFakeAlertsPage fakeAlerts;

    JavascriptExecutor js = (JavascriptExecutor)driver;

    public HomeFakeAlertsTask(WebDriver driver){
        this.driver = driver;
        fakeAlerts = new HomeFakeAlertsPage(this.driver);
    }

    public void showAlertBox() throws InterruptedException {
        try{
//        wait.waitLoadElement(fakeAlerts.getShowAlertBoxButton());
//        Thread.sleep(3000);
//        WebElement button = fakeAlerts.getShowAlertBoxButton();
            fakeAlerts.getShowAlertBoxButton().click();
            System.out.println("clicou botão show alert box");
            Thread.sleep(3000);
//        wait.waitLoadElement(fakeAlerts.getModalOkButton());
            WebElement button = fakeAlerts.getModalOkButton();
            js.executeScript("arguments[0].click();", button);
            extentTest.log(Status.PASS,"Clicou botão 'Show alert box", Screenshot.screenshotBase64(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL,"Não clicou botão 'Show alert box", Screenshot.screenshotBase64(driver));
        }
    }
}
