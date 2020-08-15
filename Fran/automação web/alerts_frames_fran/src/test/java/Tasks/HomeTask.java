package Tasks;

import PageObjects.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import support.Screenshot;

import static org.testng.Assert.assertEquals;
import static support.Report.extentTest;

public class HomeTask {

    private static WebDriver driver;
    private static HomePage home;
    private static HomeAlertsJavaScriptPage homeAlerts;
    private static HomeFakeAlertsPage homeFakeAlerts;
    private static HomeFramePage homeFrame;
    private static HomeIframePage homeIframe;

    public HomeTask(WebDriver driver){
        this.driver = driver;
        home = new HomePage(this.driver);
        homeAlerts = new HomeAlertsJavaScriptPage(this.driver);
        homeFakeAlerts = new HomeFakeAlertsPage(this.driver);
        homeFrame = new HomeFramePage(this.driver);
        homeIframe = new HomeIframePage(this.driver);
    }

    public void entrarAlertsJavaScript(){
        home.getAlertsJavaScriptButton().click();
        validarPaginaHomeAlerts();
    }

    public void entrarFakeAlerts(){
        home.getFakeAlertsButton().click();
        validarPaginaHomeFakeAlerts();
    }

    public void entrarFrame(){
        home.getFrameButton().click();
        validarPaginaHomeFrame();
    }

    public void entrarIframe(){
        home.getIframeButton().click();
        validarPaginaHomeIframe();
    }

    public void validarPaginaHomeAlerts(){
        try{
            String text = homeAlerts.getAlertBoxExamplesTextLabel().getText();
            assertEquals("Alert Box Examples", text);
            extentTest.log(Status.PASS, "Entrou a pagina 'Alert Box'", Screenshot.screenshot(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL, "Não entrou a pagina 'Alert Box'", Screenshot.screnshotBase64(driver));
        }
    }

    public void validarPaginaHomeFakeAlerts(){
        try {
            String text = homeFakeAlerts.getFakeAlertBoxExamplesTextLabel().getText();
            assertEquals("Fake Alert Box Examples", text);
            extentTest.log(Status.PASS,"Entrou a pagina 'Fake Alert Box'",Screenshot.screenshot(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL,"Não entrou a pagina 'Fake Alert Box'",Screenshot.screnshotBase64(driver));
        }
    }

    public void validarPaginaHomeFrame(){
        try {
            String text = homeFrame.getNestedFrameExampleTextLabel().getText();
            assertEquals("Nested Frames Example", text);
            driver.switchTo().defaultContent();
            extentTest.log(Status.PASS, "Entrou a pagina 'Nested Frames Example'", Screenshot.screenshotBase64(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL, "Não entrou a pagina 'Nested Frames Example'", Screenshot.screnshotBase64(driver));
        }
    }

    public void validarPaginaHomeIframe(){
        try {
            String text = homeIframe.getIframesExampleTextLabel().getText();
            assertEquals("iFrames Example", text);
            extentTest.log(Status.PASS,"Entrou a pagina 'iFrame Example'",Screenshot.screenshotBase64(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL,"Não entrou a pagina 'iFrame Example'",Screenshot.screnshotBase64(driver));
        }
    }
}
