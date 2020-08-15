package Tasks;

import PageObjects.HomeIframePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import support.Wait;

import static org.testng.Assert.assertEquals;

public class HomeIframeTask {

    private static WebDriver driver;
    private static HomeIframePage homeIframe;
    private static Wait wait;

    public HomeIframeTask(WebDriver driver){
        this.driver = driver;
        homeIframe = new HomeIframePage(this.driver);
    }

    public void iframeText(){
        validarIframeExampleList();
        validarIframeExampleHeader();
    }

    public void validarIframeExampleList(){
//        wait.waitLoadElement(homeIframe.getIframeExampleListTextLabel());
        String text = homeIframe.getIframeExampleListTextLabel().getText();
        assertEquals("iFrame List Item 1", text);
        System.out.println("Teste1: " + text);
        driver.switchTo().defaultContent();
    }

    public void validarIframeExampleHeader(){
        String text = homeIframe.getIframeExampleHeaderTextLabel().getText();
//        assertEquals("This page is used in an iFrame.\n" +
//                "        ", text);
        System.out.println("Teste2: " + text);
        driver.switchTo().defaultContent();
    }

}
