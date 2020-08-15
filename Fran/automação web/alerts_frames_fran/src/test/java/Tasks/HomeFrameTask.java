package Tasks;

import PageObjects.HomeFramePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static support.Report.extentTest;
import static support.Screenshot.screenshotBase64;

public class HomeFrameTask {

    private static WebDriver driver;
    private static HomeFramePage homeFrame;

    public HomeFrameTask(WebDriver driver){
        this.driver = driver;
        homeFrame = new HomeFramePage(this.driver);
    }

    public void frames(){
        leftValidarText();
        middleValidarText();
        rightValidarText();
    }

    public void leftValidarText(){
        try {
            String text = homeFrame.getFrameLeftTextLabel().getText();
            assertEquals("Left List Item 1",text);
            driver.switchTo().defaultContent();
            extentTest.log(Status.PASS,"'Left frame' foi validar o texto", screenshotBase64(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL,"Left frame' não foi validar o texto", screnshotBase64(driver));
        }
    }

    public void middleValidarText(){
        try {
            String text = homeFrame.getFrameMiddleTextLabel().getText();
            assertEquals("Middle List Item 11", text);
            driver.switchTo().defaultContent();
            extentTest.log(Status.PASS,"'Middle frame' foi validar o texto", screenshotBase64(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL,"'Middle frame' não foi validar o texto", screnshotBase64(driver));
        }
    }

    public void rightValidarText(){
        try {
            String text = homeFrame.getFrameRightTextLabel().getText();
            assertEquals("Right List Item 27",text);
            driver.switchTo().defaultContent();
            extentTest.log(Status.PASS,"'Right frame' foi validar o texto", screenshotBase64(driver));
        }catch (Exception e){
//            extentTest.log(Status.FAIL,"'Right frame' não foi validar o texto", screnshotBase64(driver));
        }
    }
}