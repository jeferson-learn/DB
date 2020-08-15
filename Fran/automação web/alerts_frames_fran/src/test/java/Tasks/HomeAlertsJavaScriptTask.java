package Tasks;

import PageObjects.HomeAlertsJavaScriptPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Screenshot;
import support.Wait;

import static org.testng.Assert.*;
import static support.Report.extentTest;
import static support.Screenshot.screenshot;

public class HomeAlertsJavaScriptTask {

    private static WebDriver driver;
    private static HomeAlertsJavaScriptPage homeAlerts;
    private static Wait wait;

    public HomeAlertsJavaScriptTask(WebDriver driver) {
        this.driver = driver;
        homeAlerts = new HomeAlertsJavaScriptPage(this.driver);
        wait = new Wait(driver);
    }

    public void showAlertBox() throws InterruptedException {

        homeAlerts.getShowAlertBoxButton().click(); // clicar vai aparecer alert
        Thread.sleep(2000);
        validarAlertBoxText();

    }

    public void showConfirmBoxOk() {
        homeAlerts.getShowConfirmBoxButton().click();
        validarAlertConfirmBox();
        driver.switchTo().alert().accept();
        validarConfirmReturnOK();
    }

    public void showConfirmBoxCancel() {
        homeAlerts.getShowConfirmBoxButton().click();
        validarAlertConfirmBox();
        driver.switchTo().alert().dismiss();
        validarConfirmReturnCancel();
    }

    public void showPromptBox() {
        homeAlerts.getShowPromptBoxButton().click();
        validarAlertPromptBox();
        driver.switchTo().alert().sendKeys("Jeferson");
        driver.switchTo().alert().accept();
        validarValorPromptReturn();
    }

    public void validarAlertBoxText() {
        try {

            new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
            String textAlert = driver.switchTo().alert().getText();
            assertEquals("I am an alert box!", textAlert);
            extentTest.log(Status.PASS, "Apareceu 'Alert Box'", Screenshot.screenshotBase64(driver));
            //Thread.sleep(5000);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            extentTest.log(Status.FAIL,"Não apareceu 'Alert Box'", Screenshot.screenshotBase64(driver));
        }
    }

    public void validarAlertConfirmBox() {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
            String textAlert = driver.switchTo().alert().getText();
            assertEquals("I am a confirm alert", textAlert);
            extentTest.log(Status.PASS, "Apareceu 'Alert Confirm'", Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            extentTest.log(Status.FAIL,"Não apareceu 'Alert Confirm'", Screenshot.screenshotBase64(driver));
        }
    }

    public void validarConfirmReturnOK() {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
            String textReturn = homeAlerts.getConfirmReturnTextLabel().getText();
            assertEquals("true", textReturn);
            extentTest.log(Status.PASS, "Apareceu o texto 'true'", Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            extentTest.log(Status.FAIL,"Não apareceu o texto", Screenshot.screenshotBase64(driver));
        }
    }

    public void validarConfirmReturnCancel() {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
            String textReturn = homeAlerts.getConfirmReturnTextLabel().getText();
            assertEquals("false", textReturn);
            extentTest.log(Status.PASS, "Apareceu o texto 'false'", Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            extentTest.log(Status.FAIL,"Não aparece o texto", Screenshot.screenshotBase64(driver));
        }
    }

    public void validarAlertPromptBox() {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
            String textAlert = driver.switchTo().alert().getText();
            assertEquals("I prompt you", textAlert);
            extentTest.log(Status.PASS, "Apareceu 'Alert Prompt'", Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            extentTest.log(Status.FAIL,"Não apareceu 'Alert Prompt'", Screenshot.screenshotBase64(driver));
        }
    }

    public void validarValorPromptReturn() {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
            String textReturn = homeAlerts.getPromptReturnTextLabel().getText();
            assertEquals("Jeferson", textReturn);
            extentTest.log(Status.PASS, "Apareceu o texto -> " + textReturn, Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            extentTest.log(Status.FAIL,"Não apareceu o texto", Screenshot.screenshotBase64(driver));
        }
    }

}
