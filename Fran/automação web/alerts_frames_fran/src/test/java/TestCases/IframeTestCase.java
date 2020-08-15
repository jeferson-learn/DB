package TestCases;

import Tasks.HomeIframeTask;
import Tasks.HomeTask;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import support.BaseTest;

public class IframeTestCase extends BaseTest {

    private static WebDriver driver = getDriver();
    HomeTask home = new HomeTask(driver);
    HomeIframeTask homeIframe = new HomeIframeTask(driver);

    @Test
    public void iframeTest() throws InterruptedException {
        home.entrarIframe();
        homeIframe.iframeText();
        Thread.sleep(3000);
    }
}
